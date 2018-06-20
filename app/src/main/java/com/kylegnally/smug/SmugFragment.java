package com.kylegnally.smug;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class SmugFragment extends Fragment {
    private Smug mSmug;

    public static SmugFragment newInstance() {
        return new SmugFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smug, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.linear_layout);

        return view;
    }
}
