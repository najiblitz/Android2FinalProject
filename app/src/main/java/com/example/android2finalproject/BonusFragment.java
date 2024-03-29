package com.example.android2finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BonusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BonusFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BonusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BonusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BonusFragment newInstance(String param1, String param2) {
        BonusFragment fragment = new BonusFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bonus, container, false);

        // Add custom tool
        // Create image button

        final ImageButton button = view.findViewById(R.id.bonusButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Add image content for bonus coupons

                ArrayList<Integer> images = new ArrayList<>(Arrays.asList(R.drawable.tryagain,R.drawable.tryagain,R.drawable.tryagain,R.drawable.tryagain,R.drawable.tryagain,R.drawable.tenoff,R.drawable.fifteenoff,R.drawable.twentyoff,R.drawable.twentyfiveoff,R.drawable.fiveoff,R.drawable.gift));
                Collections.shuffle(images);

                // Set mew image with coupon
                button.setImageResource(images.get(0));
                button.setEnabled(false);
            }
        });

        return view;
    }
}