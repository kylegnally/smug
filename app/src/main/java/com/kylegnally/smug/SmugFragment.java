package com.kylegnally.smug;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SmugFragment extends Fragment {
    private Smug mSmug;
    private Sound mSound;

    public static SmugFragment newInstance() {
        return new SmugFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smug, container, false);
        Button mButton = (Button) view.findViewById(R.id.smugButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSmug.play(mSound);
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSmug.release();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mSmug = new Smug(getActivity());
    }
}
