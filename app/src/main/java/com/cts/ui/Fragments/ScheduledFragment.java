package com.cts.ui.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cts.Models.Exams;
import com.cts.Models.FeesCategory;
import com.cts.R;
import com.cts.ui.Adapters.AcademicsAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class ScheduledFragment extends Fragment implements View.OnClickListener {
ImageButton backBtn;
RecyclerView scheduledExamList;
ArrayList<Exams> examsList = new ArrayList<>();
AcademicsAdapter examadapter ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scheduled, container, false);
        init(root);
        readJSONFromAsset();
        return root;
    }

    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
        scheduledExamList = root.findViewById(R.id.upcomingExamList);
        scheduledExamList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        backBtn.setOnClickListener(this);
    }
    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("Exams.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            examsList = objectMapper.readValue(json, new TypeReference<ArrayList<Exams>>() {});
            examadapter = new AcademicsAdapter(getContext(),examsList,true);
            scheduledExamList.setAdapter(examadapter);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn : {
                getFragmentManager().popBackStack();
            }
            break;
            default:{

            }
        }
    }
}