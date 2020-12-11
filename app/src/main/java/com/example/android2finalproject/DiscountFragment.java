package com.example.android2finalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiscountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DiscountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscountFragment newInstance(String param1, String param2) {
        DiscountFragment fragment = new DiscountFragment();
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
        // Inflate the layout for this fragment\

        View view = inflater.inflate(R.layout.fragment_discount, container, false);

        CustomViewPagerAdapter adapter = new CustomViewPagerAdapter(getChildFragmentManager());
        final ViewPager viewPager = view.findViewById(R.id.discountViewPager);
        viewPager.setAdapter(adapter);
        viewPager.setEnabled(false);

        AppCompatImageButton button = view.findViewById(R.id.letsGoButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(11, true);
            }
        });

        return view;
    }

    public class CustomViewPagerAdapter extends FragmentPagerAdapter {


        ArrayList<Integer> images = new ArrayList<>(Arrays.asList(R.drawable.tryagain,R.drawable.tryagain,R.drawable.tryagain,R.drawable.tryagain,R.drawable.tryagain,R.drawable.tenoff,R.drawable.fifteenoff,R.drawable.twentyoff,R.drawable.twentyfiveoff,R.drawable.fiveoff,R.drawable.gift));

        public CustomViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            Collections.shuffle(images);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
           return DiscountViewPagerFragment.newInstance(images.get(position));
        }


        @Override
        public int getCount() {
            return images.size();
        }
    }
}