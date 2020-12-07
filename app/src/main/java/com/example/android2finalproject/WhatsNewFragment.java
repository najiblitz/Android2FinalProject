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

public class WhatsNewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WhatsNewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WhatsNewFragment newInstance(String param1, String param2) {
    WhatsNewFragment fragment = new WhatsNewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_whats_new, container, false);
        CustomViewPagerAdapter adapter = new CustomViewPagerAdapter(getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.newContent);
        viewPager.setAdapter(adapter);
        return view;
    }

    public class CustomViewPagerAdapter extends FragmentPagerAdapter {


        public CustomViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return ViewPagerFragment.newInstance("1990's Toronto Blue Jays Jersey", R.drawable.jays,"Medium","$20");
                case 1:
                    return ViewPagerFragment.newInstance("1980's Faux Fur Jacket", R.drawable.fur1,"Large","$45");
                case 2:
                    return ViewPagerFragment.newInstance("1990's Multi-Colour Sequin Jacket", R.drawable.rainbow,"Large", "$30");
                case 3:
                    return ViewPagerFragment.newInstance("1960's Children's Dress", R.drawable.baby,"12-18 Months", "$10");
                case 4:
                    return ViewPagerFragment.newInstance("1980's Miami Dolphins Sweatshirt", R.drawable.dolphins,"Medium", "$10");
                case 5:
                    return ViewPagerFragment.newInstance("1980's Men's Levi Jean Jacket", R.drawable.levi,"Large", "$30");
                case 6:
                    return ViewPagerFragment.newInstance("1970's Fur Jacket", R.drawable.fur2,"Large", "$110");
                case 7:
                    return ViewPagerFragment.newInstance("1990's Nautica Jacket", R.drawable.nautica,"XX-Large", "$10");
                case 8:
                    return ViewPagerFragment.newInstance("1960's Flower Girl Dress", R.drawable.dress,"Small", "$15");
                case 9:
                    return ViewPagerFragment.newInstance("1990's Wutang Sweatshirt", R.drawable.wutang,"X-Large", "$25");
                case 10:
                    return ViewPagerFragment.newInstance("1980's Wedding Dress", R.drawable.wedding,"Small", "$45");
                case 11:
                    return ViewPagerFragment.newInstance("1990's Throwback Kobe LA Jersey", R.drawable.bryant,"X-Large", "$20");
                default: return ViewPagerFragment.newInstance("404 Not Found",R.drawable.holiday, "404 Error Found", "404 Error Found");
            }
        }

        @Override
        public int getCount() {
            return 11;
        }
    }
}