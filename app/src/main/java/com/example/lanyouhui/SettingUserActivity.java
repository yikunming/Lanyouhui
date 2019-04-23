package com.example.lanyouhui;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lanyouhui.api.ApiUser;
import com.example.lanyouhui.uitl.ApiUrl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import EntityClass.PostResult;
import EntityClass.UserInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SettingUserActivity extends AppCompatActivity {

    private String token;
    private LinearLayout pcdPersonal;
    private EditText personalName;
    private EditText personalIntro;
    private LinearLayout linGender;
    private EditText personalGender;
    private LinearLayout personalLinBir;
    private TextView personalBir;
    private LinearLayout pcdCommonProblem;
    private EditText personalArea;
    private LinearLayout pcdSetting;
    private TextView settingBt;
    private UserInfo userInfo = new UserInfo();
    private String time;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initData();
        initEvent();

    }

    private void initView() {

        pcdPersonal = (LinearLayout) findViewById(R.id.pcd_personal);
        personalName = (EditText) findViewById(R.id.personal_name);
        personalIntro = (EditText) findViewById(R.id.personal_intro);
        linGender = (LinearLayout) findViewById(R.id.lin_gender);
        personalGender = (EditText) findViewById(R.id.personal_gender);
        personalLinBir = (LinearLayout) findViewById(R.id.personal_lin_bir);
        personalBir = (TextView) findViewById(R.id.personal_bir);
        pcdCommonProblem = (LinearLayout) findViewById(R.id.pcd_commonProblem);
        personalArea = (EditText) findViewById(R.id.personal_area);
        pcdSetting = (LinearLayout) findViewById(R.id.pcd_setting);
        settingBt = (TextView) findViewById(R.id.setting_bt);

    }

    private void initData() {
        // TODO: 2019/4/23 phone问题
        getToken();
        userInfo.setPhone("17608029745");

        Intent intent = getIntent();
        userInfo.setArea(intent.getStringExtra("area") + "");
        time = intent.getStringExtra("bir");
        userInfo.setGender(intent.getStringExtra("gen") + "");
        userInfo.setGender(intent.getStringExtra("gen") + "");
        userInfo.setName(intent.getStringExtra("name") + "");
        userInfo.setIntroduction(intent.getStringExtra("intro") + "");

        personalArea.setText(userInfo.getArea());
        personalName.setText(userInfo.getName());
        personalBir.setText(time.subSequence(3,time.length()));
        personalIntro.setText(userInfo.getIntroduction());
        if (userInfo.getGender().equals("0")) {
            personalGender.setText("女");
        } else {
            personalGender.setText("男");
        }
    }

    private void initEvent() {
        personalLinBir.setOnClickListener(v -> {
            chooseBir();
        });

        settingBt.setOnClickListener(v -> {

            if(!personalGender.getText().toString().trim().equals("男") && !personalGender.getText().toString().trim().equals("女")){
                Toast.makeText(SettingUserActivity.this, "请正确填写性别!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (personalGender.getText().equals("男")) {
                userInfo.setGender("1");
            }else {
                userInfo.setGender("0");
            }
            updateUserInfo();
        });
    }

    private void chooseBir() {
        final Calendar c = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(SettingUserActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO: 2019/4/23 暂未修改时问题解决
//                Date date =c.getTime();
//                userInfo.setBirthday(date);
                c.set(year, monthOfYear, dayOfMonth);
                personalBir.setText(DateFormat.format("yyy.MM.dd", c));
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        dialog.show();

    }

    private void updateUserInfo() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.APIBAST) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析
                .build();

        // 步骤5:创建 网络请求接口 的实例
        ApiUser request = retrofit.create(ApiUser.class);
        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<PostResult> call = request.modifyUserInfo(userInfo);
        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<PostResult>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                if (response.isSuccessful()) {
                    Log.e("test", "onResponse: " + response.body().isSuccess());
                    if (response.body().isSuccess()) {
                        Toast.makeText(SettingUserActivity.this, "修改成功!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(SettingUserActivity.this, "修改失败!", Toast.LENGTH_SHORT).show();
                        Log.e("test", "onResponse: " + response.body().getErrMsg() );
                    }

                }
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<PostResult> call, Throwable throwable) {
                Toast.makeText(SettingUserActivity.this, "兄弟有错误哦!" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("test", "onFailure: 修改失败" + throwable.getMessage());
            }
        });
    }

    private void getToken(){
        //读取用户token
        SharedPreferences myPreference=getSharedPreferences("myPreference", Context.MODE_PRIVATE);
        token = myPreference.getString("USER_KEY", "17608029745");
    }
}
