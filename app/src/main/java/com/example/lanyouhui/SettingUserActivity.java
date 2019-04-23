package com.example.lanyouhui;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.stringtemplate.v4.ST;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import EntityClass.UserInfo;

public class SettingUserActivity extends AppCompatActivity {

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
        Intent intent = getIntent();
        userInfo.setArea(intent.getStringExtra("area") + "");
        time = intent.getStringExtra("bir");
        userInfo.setGender(intent.getStringExtra("gen") + "");
        userInfo.setName(intent.getStringExtra("name") + "");
        userInfo.setIntroduction(intent.getStringExtra("intro") + "");

        personalArea.setText(userInfo.getArea());
        personalName.setText(userInfo.getName());
        personalBir.setText(time);
        personalIntro.setText(userInfo.getIntroduction());
        if (userInfo.getGender().equals("0")) {
            personalGender.setText("性别:女");
        } else {
            personalGender.setText("性别:男");
        }
    }

    private void initEvent() {
        personalLinBir.setOnClickListener(v -> {
            chooseBir();
        });

        settingBt.setOnClickListener(v -> {
            updateUserInfo();
        });
    }

    private void chooseBir() {
        final Calendar c = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(SettingUserActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                c.set(year, monthOfYear, dayOfMonth);
                personalBir.setText(DateFormat.format("yyy.MM.dd", c));
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        dialog.show();

    }

    private void updateUserInfo() {

    }
}
