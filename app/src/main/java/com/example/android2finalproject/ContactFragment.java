package com.example.android2finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean sizeOption = sharedPrefs.getBoolean("buttonSize", false);
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        final ImageButton emailButton = view.findViewById(R.id.emailButton);
        emailButton.startAnimation(R.anim.slide_in);
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

        ImageButton locationButton = view.findViewById(R.id.locationButton);
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

        ImageButton instagramButton = view.findViewById(R.id.instagramButton);
        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/vinces.vintage.finds/"));
                intent.setPackage("com.instagram.android");
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton phoneButton = view.findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:5195559090");
                Intent intent = new Intent(Intent.ACTION_DIAL, number);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton websiteButton = view.findViewById(R.id.websiteButton);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri website = Uri.parse("http://www.vincesvintagefinds.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, website);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton shareButton = view.findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:"));
            intent.putExtra("sms_body","Check Out Vince's Vintage Finds:" +
                    "https:/www.vincesvintagefinds.com");
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton facebookButton = view.findViewById(R.id.facebookButton);
        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/vinces.vintage.finds/"));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(475,425);
        LinearLayout.LayoutParams largerParams = new LinearLayout.LayoutParams(500,425);
        LinearLayout.LayoutParams smallParams = new LinearLayout.LayoutParams(300,250);
        LinearLayout.LayoutParams smallLargeParams = new LinearLayout.LayoutParams(340,250);
        LinearLayout.LayoutParams shareSmall = new LinearLayout.LayoutParams(400,250);
        LinearLayout.LayoutParams shareLarge = new LinearLayout.LayoutParams(570,425);


        params.gravity = Gravity.CENTER;
        largerParams.gravity = Gravity.CENTER;
        smallParams.gravity = Gravity.CENTER;
        smallLargeParams.gravity = Gravity.CENTER;
        shareLarge.gravity = Gravity.CENTER;
        shareSmall.gravity = Gravity.CENTER;

        if (sizeOption) {
            phoneButton.setLayoutParams(params);
            emailButton.setLayoutParams(params);
            websiteButton.setLayoutParams(params);
            locationButton.setLayoutParams(largerParams);
            instagramButton.setLayoutParams(largerParams);
            shareButton.setLayoutParams(shareLarge);
            facebookButton.setLayoutParams(largerParams);
        } else {
            phoneButton.setLayoutParams(smallParams);
            emailButton.setLayoutParams(smallParams);
            websiteButton.setLayoutParams(smallParams);
            locationButton.setLayoutParams(smallLargeParams);
            instagramButton.setLayoutParams(smallLargeParams);
            shareButton.setLayoutParams(shareSmall);
            facebookButton.setLayoutParams(smallLargeParams);
        }

        return view;
    }


}