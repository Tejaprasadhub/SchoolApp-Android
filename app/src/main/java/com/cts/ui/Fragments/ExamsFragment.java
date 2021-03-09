package com.cts.ui.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.cts.R;
import com.cts.ui.Fragments.ResultFragment;
import com.cts.ui.Fragments.ScheduledFragment;


public class ExamsFragment extends Fragment implements  View.OnClickListener{
Button scheduledBtn,resultBtn;
ImageButton backBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_exams, container, false);
        init(root);
        return root;
    }

    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
        scheduledBtn = root.findViewById(R.id.scheduledExam);
        resultBtn = root.findViewById(R.id.results);
        backBtn.setOnClickListener(this);
        scheduledBtn.setOnClickListener(this);
        resultBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn:{
                getFragmentManager().popBackStack();
            }
            break;
            case R.id.scheduledExam : {
                    ScheduledFragment scheduledFragment = new ScheduledFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.framelayout, scheduledFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
            }
            break;
            case R.id.results : {
                ResultFragment resultFragment = new ResultFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout,resultFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
            break;
        }
    }
}