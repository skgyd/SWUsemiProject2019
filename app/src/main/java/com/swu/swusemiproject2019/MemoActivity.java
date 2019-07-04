package com.swu.swusemiproject2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MemoActivity extends AppCompatActivity {
    private TabLayout tabLayout;    //tab영역
    private ViewPager viewPager;    //tab별 표시할 영역


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        //tab 생성
        tabLayout.addTab(tabLayout.newTab().setText("글쓰기"));
        tabLayout.addTab(tabLayout.newTab().setText("사진찍기"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //ViewPager 생성
        myPagerAdapter adapter = new myPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener()

        {
            @Override
            public void onTabSelected (TabLayout.Tab tab){
                viewPager.setCurrentItem(tab.getPosition());    //tab과 pager 연동
            }

            @Override
            public void onTabUnselected (TabLayout.Tab tab){
                //사용 x
            }

            @Override
            public void onTabReselected (TabLayout.Tab tab){
                //사용 x
            }
        });
    }


    class myPagerAdapter extends FragmentPagerAdapter {
        int tabSize;    //TAB 수

        public myPagerAdapter(FragmentManager fm, int count) {
            super(fm);
            this.tabSize = count; //탭의 수
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment_newMemo();
                case 1:
                    return new Fragment_Camera();
            }
            return null;
        }

        @Override
        public int getCount() {
            return this.tabSize;
        }
    }

}

