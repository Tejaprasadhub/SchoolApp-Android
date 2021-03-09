package com.cts.ui.Fragments.ParentSide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cts.Models.TeachersResponse;
import com.cts.Models.TimeTableResponse;
import com.cts.R;
import com.cts.ui.Adapters.TeachersAdapter;
import com.cts.ui.Adapters.TimeTableAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TeacherFragment extends Fragment {
ImageButton backBtn;
RecyclerView teacherRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_teacher, container, false);
        init(root);
        initListeners();
        readJSONFromAsset();
        return root;
    }

    private void initListeners() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
    }

    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
        teacherRecyclerView = root.findViewById(R.id.teacherList);
        teacherRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("Teachers.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<TeachersResponse> myData = objectMapper.readValue(json, new TypeReference<ArrayList<TeachersResponse>>() {});
            TeachersAdapter myAdapter = new TeachersAdapter(getContext(),myData);
            teacherRecyclerView.setAdapter(myAdapter);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}