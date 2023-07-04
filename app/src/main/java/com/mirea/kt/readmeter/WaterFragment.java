package com.mirea.kt.readmeter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WaterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_water, container,false);
        TextView tv = rootView.findViewById(R.id.textView1);
        tv.setText("это первый фрагмент воды");
        return rootView;
    }
}