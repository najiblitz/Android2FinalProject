package com.example.android2finalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        Button emailButton = view.findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] emailAddress = {"w0549527@myscc.ca"};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Question/Comment from Vince's Vintage App");
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        Button locationButton = view.findViewById(R.id.locationButton);
        locationButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=42.0485549,-82.6181520(Vintage Vince");
                Intent intent = new Intent(Intent.ACTION_VIEW, location);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        Button phoneButton = view.findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button instagramButton = view.findViewById(R.id.instagramButton);
        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button websiteButton = view.findViewById(R.id.websiteButton);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri website = Uri.parse("http://www.vintagevince.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, website);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}