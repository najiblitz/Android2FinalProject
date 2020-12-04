package com.example.android2finalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class WhatsNewFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_whats_new, container, false);
        ((ViewPager)view.findViewById(R.id.viewpager)).setAdapter(new CustomViewPagerAdapter(getChildFragmentManager()));
        return view;

    }

    private class CustomViewPagerAdapter extends FragmentPagerAdapter {

        String[] descriptionContent = {"frruhfir","dfjiowejfioewf"};
        int[] imageContent = {R.drawable.picture,R.drawable.ic_menu_camera};

        public CustomViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position >= imageContent.length || position < 0) {
                return viewPagerFragment.newInstance("error",0);
            }
            return viewPagerFragment.newInstance(descriptionContent[position],imageContent[position]);
        }

        @Override
        public int getCount() {
            return imageContent.length;
        }
    }
}