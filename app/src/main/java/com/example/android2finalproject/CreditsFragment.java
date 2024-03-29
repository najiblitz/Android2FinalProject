package com.example.android2finalproject;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreditsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreditsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreditsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreditsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreditsFragment newInstance(String param1, String param2) {
        CreditsFragment fragment = new CreditsFragment();
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
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean sizeOption = sharedPrefs.getBoolean("textSize", false);
        String colorChoice = sharedPrefs.getString("textColor", "Black");
        View view =inflater.inflate(R.layout.fragment_credits, container, false);
        TextView creditContent1 = view.findViewById(R.id.creditContent1);
        TextView creditContent2 = view.findViewById(R.id.creditContent2);
        TextView creditContent3 = view.findViewById(R.id.creditContent3);

        // Add Settings used

        if (sizeOption) {
            creditContent1.setTextSize(40);
            creditContent2.setTextSize(40);
            creditContent3.setTextSize(40);
        } else {
            creditContent1.setTextSize(25);
            creditContent2.setTextSize(25);
            creditContent3.setTextSize(25);
        }

        switch (colorChoice) {
            case "Black":
                creditContent1.setTextColor(Color.BLACK);
                creditContent2.setTextColor(Color.BLACK);
                creditContent3.setTextColor(Color.BLACK);
                break;
            case "Pink":
                creditContent1.setTextColor(getResources().getColor(R.color.pinkText));
                creditContent2.setTextColor(getResources().getColor(R.color.pinkText));
                creditContent3.setTextColor(getResources().getColor(R.color.pinkText));
                break;
            case "Blue":
                creditContent1.setTextColor(getResources().getColor(R.color.darkText));
                creditContent2.setTextColor(getResources().getColor(R.color.darkText));
                creditContent3.setTextColor(getResources().getColor(R.color.darkText));
                break;
            case "Default":
                creditContent1.setTextColor(getResources().getColor(R.color.darkText));
                creditContent2.setTextColor(getResources().getColor(R.color.pinkText));
                creditContent3.setTextColor(getResources().getColor(R.color.darkText));
                break;
        }
        return view;
    }
}