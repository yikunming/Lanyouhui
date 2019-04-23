package com.example.lanyouhui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanyouhui.api.ApiUser;
import com.example.lanyouhui.uitl.ApiUrl;

import java.text.SimpleDateFormat;

import EntityClass.ResultDetail;
import EntityClass.UserInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonalActivity extends AppCompatActivity {

    private String token;
    private TextView login;
    private LinearLayout pcdPersonal;
    private ImageView personalHead;
    private TextView personalName;
    private TextView personalIntro;
    private TextView personalGender;
    private TextView personalBir;
    private LinearLayout pcdCommonProblem;
    private TextView personalArea;
    private LinearLayout pcdSetting;
    private TextView personalSitting;
    private UserInfo userInfo;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);


        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonalActivity.this,MainActivity.class);
            }
        });
        initView();
        initDate();
        initEvent();

    }

    private void initDate() {
        userInfo = new UserInfo();
        getToken();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.APIBAST) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
//                .addConverterFactory(new Retrofit2ConverterFactory())
                .build();
        // 步骤5:创建 网络请求接口 的实例
        ApiUser request = retrofit.create(ApiUser.class);
        //对 发送请求 进行封装
        Call<ResultDetail<UserInfo>> call = request.getUserInfo(token);

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<ResultDetail<UserInfo>>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<ResultDetail<UserInfo>> call, Response<ResultDetail<UserInfo>> response) {
                if (response.isSuccessful()){
                    userInfo = response.body().getSuccess();
                    Log.e("test", "onResponse: " + userInfo.toString() );
                    Glide.with(PersonalActivity.this).load(ApiUrl.HEADBATS + userInfo.getImg()).into(personalHead);
                    if (userInfo.getGender().equals("0")){
                        personalGender.setText("性别:女");
                    }else {
                        personalGender.setText("性别:男");
                    }

                    if (!userInfo.getArea().equals("")){
                        personalArea.setText("居住地:" + userInfo.getArea());
                    }

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                    if (!userInfo.getBirthday().toString().equals("")){
                        personalBir.setText("生日:" + simpleDateFormat.format(userInfo.getBirthday()));
                    }
                    if (!userInfo.getIntroduction().equals("")){
                        personalIntro.setText(userInfo.getIntroduction());
                    }
                   if (!userInfo.getName().equals("")){
                       personalName.setText(userInfo.getName());
                   }

                    // 步骤7：处理返回的数据结果
                    Log.e("test", "请求成功: " );
                }


            }
            //请求失败时回调
            @Override
            public void onFailure(Call<ResultDetail<UserInfo>> call, Throwable t) {
                Log.e("test", "请求失败: " + t.toString() );
            }
        });
    }

    private void initView() {
        personalHead = (ImageView) findViewById(R.id.personal_head);
        personalName = (TextView) findViewById(R.id.personal_name);
        personalIntro = (TextView) findViewById(R.id.personal_intro);
        personalGender = (TextView) findViewById(R.id.personal_gender);
        personalBir = (TextView) findViewById(R.id.personal_bir);
        pcdCommonProblem = (LinearLayout) findViewById(R.id.pcd_commonProblem);
        personalArea = (TextView) findViewById(R.id.personal_area);
        pcdSetting = (LinearLayout) findViewById(R.id.pcd_setting);
        personalSitting = (TextView) findViewById(R.id.personal_sitting);
    }

    private void initEvent() {

        pcdSetting.setOnClickListener(v -> {
            Intent intent = new Intent(PersonalActivity.this, SettingUserActivity.class);
            intent.putExtra("area",userInfo.getArea());
            intent.putExtra("bir",userInfo.getBirthday());
            intent.putExtra("gen",personalGender.getText());
            intent.putExtra("name",userInfo.getName());
            intent.putExtra("intro",userInfo.getIntroduction());
            startActivity(intent);
        });

    }

    private void getToken(){
        //读取用户token
        SharedPreferences myPreference=getSharedPreferences("myPreference", Context.MODE_PRIVATE);
        token = myPreference.getString("USER_KEY", "17608029745");
    }
}