package org.yaoming.mydemos.libcollections.democode.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import org.yaoming.mydemos.libcollections.R;
import org.yaoming.mydemos.libcollections.global.YFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/3/1.
 */
public class DemoCodeFragment extends YFragment {

    private ViewPager mViewPager;
    private TabLayout mTablayout;
    public static final int DEMOCODE_TABTITLE_UI = 0;
    public static final int DEMOCODE_TABTITLE_FUNCTION = 1;
    public static final int DEMOCODE_TABTITLE_DATABASE = 2;

    public DemoCodeFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo_code, null);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mTablayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager.setOffscreenPageLimit(3);
        setupViewPager(mViewPager);
        mTablayout.addTab(mTablayout.newTab().setText(R.string.democode_tab_title_UI));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.democode_tab_title_function));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.democode_tab_title_database));
        mTablayout.setupWithViewPager(mViewPager);
        return view;
    }

    private void setupViewPager(ViewPager mViewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        adapter.addFragment(DemoCodeListFragment.newInstance(DEMOCODE_TABTITLE_UI), getString(R.string.democode_tab_title_UI));
        adapter.addFragment(DemoCodeListFragment.newInstance(DEMOCODE_TABTITLE_FUNCTION), getString(R.string.democode_tab_title_function));
        adapter.addFragment(DemoCodeListFragment.newInstance(DEMOCODE_TABTITLE_DATABASE), getString(R.string.democode_tab_title_database));
        mViewPager.setAdapter(adapter);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

}
