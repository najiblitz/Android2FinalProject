package com.example.android2finalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutUsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView answer;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AboutUsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutUsFragment newInstance(String param1, String param2) {
        AboutUsFragment fragment = new AboutUsFragment();
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
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        final ListView listView = view.findViewById(R.id.aboutUsList);
        answer = view.findViewById(R.id.answer);
        ArrayList<AboutUsInfo> aboutUsInfoArrayList = new ArrayList<>();

        aboutUsInfoArrayList.add(new AboutUsInfo("" + getResources().getString(R.string.question1), "" + getResources().getString(R.string.answer1)));
        aboutUsInfoArrayList.add(new AboutUsInfo("" + getResources().getString(R.string.question2), "" + getResources().getString(R.string.answer2)));
        aboutUsInfoArrayList.add(new AboutUsInfo("" + getResources().getString(R.string.question3), "" + getResources().getString(R.string.answer3)));
        aboutUsInfoArrayList.add(new AboutUsInfo("" + getResources().getString(R.string.question4), "" + getResources().getString(R.string.answer4)));
        aboutUsInfoArrayList.add(new AboutUsInfo("" + getResources().getString(R.string.question5), "" + getResources().getString(R.string.answer5)));
        aboutUsInfoArrayList.add(new AboutUsInfo("" + getResources().getString(R.string.question6), "" + getResources().getString(R.string.answer6)));
        listView.setAdapter(new CustomListViewAdapter(getContext(), aboutUsInfoArrayList));

        return view;
    }

    public class CustomListViewAdapter extends ArrayAdapter<AboutUsInfo>{

        public CustomListViewAdapter(@NonNull Context context, ArrayList<AboutUsInfo> infos) {
            super(context, 0, infos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
           SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
           boolean sizeOption = sharedPrefs.getBoolean("textSize", false);
           String colorChoice = sharedPrefs.getString("textColor", "Black");
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_about_us, parent,false);
                TextView question = convertView.findViewById(R.id.question);
                question.setText(getItem(position).getQuestion());
                TextView answer = convertView.findViewById(R.id.answer);
                answer.setText(getItem(position).getAnswer());

                if (sizeOption) {
                    question.setTextSize(40);
                    answer.setTextSize(40);
                } else {
                    question.setTextSize(30);
                    answer.setTextSize(30);
                }

            switch (colorChoice) {
                case "Black":
                    question.setTextColor(Color.BLACK);
            break;
                case "Pink":
                    break;
                }

            return convertView;


        }
    }

}