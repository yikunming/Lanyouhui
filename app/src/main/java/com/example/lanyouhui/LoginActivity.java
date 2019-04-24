package com.example.lanyouhui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lanyouhui.api.ApiUser;
import com.example.lanyouhui.uitl.ApiUrl;

import EntityClass.PostResult;
import EntityClass.ResultDetail;
import EntityClass.UserLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private static String TAG = "test";
    private TextView register;
    private EditText loginInputphone;
    private EditText loginInputpwd;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (TextView) findViewById(R.id.login_register);
        loginInputphone = (EditText) findViewById(R.id.login_inputphone);
        loginInputpwd = (EditText) findViewById(R.id.login_inputpwd);
        loginBtn = (Button) findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(v -> {

            if (loginInputphone.getText().toString().equals("") || loginInputpwd.getText().toString().equals("")) {
                Toast.makeText(this, "账号或密码未填!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                login();
            }

        });

        register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

    }

    /**
     * 登录
     */
    private void login() {
        UserLogin userLogin = new UserLogin();
        userLogin.setPassword(loginInputpwd.getText().toString());
        userLogin.setUserPhone(loginInputphone.getText().toString());
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.APIBAST) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析
                .build();

        // 步骤5:创建 网络请求接口 的实例
        ApiUser request = retrofit.create(ApiUser.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<PostResult> call = request.loginUserInfo(userLogin);

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<PostResult>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                if (response.isSuccessful()) {
                    Log.e(TAG, "onResponse: " + response.body().isSuccess());
                    if (response.body().isSuccess()) {
                        //储存用户token
                        myShared(userLogin.getUserPhone());
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Toast.makeText(LoginActivity.this, "登录成功!", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "账号或密码错误!", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<PostResult> call, Throwable throwable) {
                Toast.makeText(LoginActivity.this, "兄弟有错误哦!" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: 请求失败" + throwable.getMessage());
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
