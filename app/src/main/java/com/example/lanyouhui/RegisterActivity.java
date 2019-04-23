package com.example.lanyouhui;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lanyouhui.api.ApiUser;
import com.example.lanyouhui.uitl.ApiUrl;

import EntityClass.PostResult;
import EntityClass.UserLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity{

    private EditText registerInputphone;
    private EditText registerInputpwd;
    private EditText registerSeekpwd;
    private RadioButton registerAgreeBt;
    private TextView userAgreement;
    private Button registerDefinebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initEvent();

    }

    private void initView() {
        registerInputphone = (EditText) findViewById(R.id.register_inputphone);
        registerInputpwd = (EditText) findViewById(R.id.register_inputpwd);
        registerSeekpwd = (EditText) findViewById(R.id.register_seekpwd);
        registerAgreeBt = (RadioButton) findViewById(R.id.register_agree_bt);
        userAgreement = (TextView) findViewById(R.id.user_agreement);
        registerDefinebtn = (Button) findViewById(R.id.register_definebtn);
    }

    private void initEvent() {

        registerDefinebtn.setOnClickListener(v -> {
            if (registerInputphone.getText().toString().equals("")||registerInputpwd.getText().toString().equals("")
                    ||registerSeekpwd.getText().toString().equals("")){
                Toast.makeText(RegisterActivity.this, "账号或密码为空!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (registerInputphone.getText().toString().length() != 11){
                Toast.makeText(RegisterActivity.this, "请输入11位的手机号哦!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!registerInputpwd.getText().toString().equals(registerSeekpwd.getText().toString())){
                Toast.makeText(RegisterActivity.this, "两次密码不一致!", Toast.LENGTH_SHORT).show();
                return;
            }

            register();

        });

    }

    /**
     * 注册
     */
    private void register() {
        UserLogin userLogin = new UserLogin();
        userLogin.setPassword(registerInputpwd.getText().toString());
        userLogin.setUserPhone(registerInputphone.getText().toString());
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.APIBAST) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析
                .build();

        // 步骤5:创建 网络请求接口 的实例
        ApiUser request = retrofit.create(ApiUser.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<PostResult> call = request.registerUserInfo(userLogin);

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<PostResult>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                if (response.isSuccessful()){
                    Log.e("test", "onResponse: " + response.body().isSuccess());
                    if (response.body().isSuccess()){
                        myShared(userLogin.getUserPhone());
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        Toast.makeText(RegisterActivity.this, "注册成功!", Toast.LENGTH_SHORT).show();

                        startActivity(intent);
                    }else {
                        Toast.makeText(RegisterActivity.this, "账号或密码错误!", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<PostResult> call, Throwable throwable) {
                Toast.makeText(RegisterActivity.this, "兄弟有错误哦!" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("test", "onFailure: 请求失败" + throwable.getMessage());
            }
        });
    }

    /**
     * 储存用户token
     * @param phone
     */
    private void myShared(String phone) {
        SharedPreferences myPreference = getSharedPreferences("userShared", Context.MODE_PRIVATE);
        //向SharedPreference中写入数据需要使用Editor
        SharedPreferences.Editor editor = myPreference.edit();
        //存入键值对数据，注意此处的put[type]("key",value);
        editor.putString("USER_KEY", phone);
        //提交保存
//        editor.apply();
        editor.commit();
    }

}