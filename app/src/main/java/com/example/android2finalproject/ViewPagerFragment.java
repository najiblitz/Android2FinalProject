package com.example.android2finalproject;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewPagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPagerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
    private String mParam3;
    private String mParam4;

    public ViewPagerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param2 Parameter 2.
     * @return A new instance of fragment WhatsNewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewPagerFragment newInstance(String param1, int param2, String param3, String param4) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean sizeOption = sharedPrefs.getBoolean("textSize", false);
        String colorChoice = sharedPrefs.getString("textColor", "Black");
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        TextView title = view.findViewById(R.id.newTitle);
        ImageView picture = view.findViewById(R.id.image);
        TextView size = view.findViewById(R.id.newSize);
        TextView price = view.findViewById(R.id.newPrice);

        if (mParam1 != null && mParam2 != 0 && mParam3 != null && mParam4 != null) {
            title.setText(mParam1);
            picture.setImageResource(mParam2);
            size.setText("Size: " + mParam3);
            price.setText("Price: " + mParam4);
        }

        if (sizeOption) {
            title.setTextSize(40);
            size.setTextSize(40);
            price.setTextSize(40);
        } else {
            title.setTextSize(25);
            size.setTextSize(25);
            price.setTextSize(25);
        }

        switch (colorChoice) {
            case "Black":
                title.setTextColor(Color.BLACK);
                size.setTextColor(Color.BLACK);
                price.setTextColor(Color.BLACK);
                break;
            case "Pink":
                title.setTextColor(getResources().getColor(R.color.pinkText));
                size.setTextColor(getResources().getColor(R.color.pinkText));
                price.setTextColor(getResources().getColor(R.color.pinkText));
                break;
            case "Blue":
                title.setTextColor(getResources().getColor(R.color.darkText));
                size.setTextColor(getResources().getColor(R.color.darkText));
                price.setTextColor(getResources().getColor(R.color.darkText));
                break;
            case "Default":
                title.setTextColor(getResources().getColor(R.color.pinkText));
                size.setTextColor(getResources().getColor(R.color.darkText));
                price.setTextColor(getResources().getColor(R.color.darkText));
                break;
        }


        return view;
    }
}