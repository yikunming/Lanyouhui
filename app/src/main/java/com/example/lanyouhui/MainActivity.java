package com.example.lanyouhui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyStateAdapter;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity implements
        BottomNavigationBar.OnTabSelectedListener,ViewPager.OnPageChangeListener {

    private BottomNavigationBar bottomBar;
    private ViewPager viewPager;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private ForthFragment forthFragment;
    private MyAdapter myAdapter;
    private MyStateAdapter myStateAdapter;

    private ImageView imageView;

    private ImageView imageView2;

    private List<Fragment> fragmentList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.image_find);

        imageView2=findViewById(R.id.image_information);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,FindActivity.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,PersonalActivity.class);
                startActivity(intent);
            }
        });

        initBottom();
        initViewPager();
    }

    private void initBottom() {
        bottomBar = findViewById(R.id.bottom_nav_bar);
        BottomNavigationItem firstItem = new BottomNavigationItem(R.drawable.icon_mine,"推荐");
        BottomNavigationItem secondItem = new BottomNavigationItem(R.drawable.icon_nba,"NBA");
        BottomNavigationItem thirdItem = new BottomNavigationItem(R.drawable.icon_cba,"CBA");
        BottomNavigationItem forthItem = new BottomNavigationItem(R.drawable.icon_up,"技巧");
        bottomBar.addItem(firstItem);
        bottomBar.addItem(secondItem);
        bottomBar.addItem(thirdItem);
        bottomBar.addItem(forthItem);
        bottomBar.initialise();
        bottomBar.setTabSelectedListener(this);
    }

    private void initViewPager() {
        viewPager = findViewById(R.id.viewpager);
        viewPager.setClipChildren(false);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        forthFragment = new ForthFragment();
        fragmentList.add(firstFragment);
        fragmentList.add(secondFragment);
        fragmentList.add(thirdFragment);
        fragmentList.add(forthFragment);
//        myAdapter = new MyAdapter(this.getSupportFragmentManager(),fragmentList);
        myStateAdapter = new MyStateAdapter(this.getSupportFragmentManager(),fragmentList);
//        viewPager.setAdapter(myAdapter);
        viewPager.setAdapter(myStateAdapter);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
