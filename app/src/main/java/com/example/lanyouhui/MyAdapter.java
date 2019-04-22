package com.example.lanyouhui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 易锟铭 on 2019/1/2.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private List<Fragment>fragmentList;
    public MyAdapter(FragmentManager fragmentManager,List<Fragment>fragmentList){
        super(fragmentManager);
        this.fragmentList=fragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
