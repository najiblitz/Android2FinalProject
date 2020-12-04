package com.example.android2finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link viewPagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class viewPagerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam2;
    private int image;

    public viewPagerFragment() {
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
    public static WhatsNewFragment newInstance(String param2, int image) {
        WhatsNewFragment fragment = new WhatsNewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam2 = getArguments().getString(ARG_PARAM2);
            image = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        if (mParam2 != null && image != 0) {
            Log.d("testingError", "onCreateView: imageLoaded");
            ( (ImageView) view.findViewById(R.id.image)).setImageResource(image);
            ( (TextView) view.findViewById(R.id.description)).setText(mParam2);

        }


        Log.d("testingError", "onCreateView: afterIf");
        // Inflate the layout for this fragment

        return view;
    }
}