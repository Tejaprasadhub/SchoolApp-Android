package com.cts.ui.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cts.R;

public class ReferFragment extends Fragment implements View.OnClickListener {

    Button ShareBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_refer, container, false);
        init(root);
        return root;
    }

    private void init(View root) {
        ShareBtn = root.findViewById(R.id.shareBtn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shareBtn : {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                Uri appUrl = Uri.parse("https://play.google.com/store/apps/details?id=com.flipkart.android");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, appUrl);
                startActivity(sharingIntent);
            }
            break;
            default:{

            }
        }
    }
}