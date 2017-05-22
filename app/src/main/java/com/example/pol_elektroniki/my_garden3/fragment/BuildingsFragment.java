package com.example.pol_elektroniki.my_garden3.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pol_elektroniki.my_garden3.R;

/**
 * Created by Pol-elektroniki on 2017-05-17.
 */

public class BuildingsFragment extends Fragment {
    public BuildingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buildings, container, false);
    }
}

