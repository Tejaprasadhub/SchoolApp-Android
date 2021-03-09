package com.cts.ui.Fragments.TeacherSide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cts.Models.NoticeBoard;
import com.cts.Models.TeachersHomeWork;
import com.cts.R;
import com.cts.ui.Adapters.NoticeBoardAdapter;
import com.cts.ui.Adapters.TeacherHomeWorkAdapter;
import com.cts.ui.Fragments.ExamsFragment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class TeacherHomeworkFragment extends Fragment implements View.OnClickListener {
ImageButton backBtn,addHomeworkBtn;
RecyclerView homeWorkList;
TextView noHomeWork;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_teacher_homework, container, false);
        init(root);
        readJSONFromAsset();
        return root;
    }

    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
        addHomeworkBtn = root.findViewById(R.id.addHomeWorkBtn);
        homeWorkList = root.findViewById(R.id.homeWorkList);
        homeWorkList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        noHomeWork = root.findViewById(R.id.noHomeworks);
        addHomeworkBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("Teacher_homework.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<TeachersHomeWork> myData = objectMapper.readValue(json, new TypeReference<ArrayList<TeachersHomeWork>>() {});
            TeacherHomeWorkAdapter myAdapter = new TeacherHomeWorkAdapter(getContext(),myData);
            homeWorkList.setAdapter(myAdapter);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.backBtn:{
        getFragmentManager().popBackStack();
    }
    break;
    case R.id.addHomeWorkBtn : {
        AddHomeWorkFragment addHomeWorkFragment = new AddHomeWorkFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, addHomeWorkFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    break;
    default:{

    }
}
    }
}