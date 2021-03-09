package com.cts.ui.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.cts.Models.DropDownData;
import com.cts.Models.Exams;
import com.cts.R;
import com.cts.ui.Adapters.DropDownCustomAdapter;
import com.cts.ui.Adapters.ResultSubjectsAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class ResultFragment extends Fragment implements View.OnClickListener {
ImageButton backBtn;
LinearLayout examSearchLayout,classSerachLayout,searchBtnLayout;
RelativeLayout resultDataLayout,searchLayout,NodataLayout;
RecyclerView subjectsList;
TextView examName,className,examStartDate,examEndDate,totalMarks,securedMarks,status,selectClass,selectExam;
ArrayList<Exams> examsList = new ArrayList<>();
ArrayList<DropDownData> myClasses = new ArrayList<>();
ArrayList<DropDownData> myExams = new ArrayList<>();
Spinner examSpinner,classSpinner;
DropDownData selectedExamData,selectedClassdata ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_result, container, false);
        init(root);
        initListeners();
        readJSONFromAsset();
        return  root;
    }

    private void initListeners() {
        examSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             selectExam.setVisibility(View.GONE);
             selectedExamData = myExams.get(i);
             if(selectedExamData != null && selectedClassdata != null){
               findMyResult()  ;
             }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                examSpinner.setVisibility(View.GONE);
                selectExam.setVisibility(View.VISIBLE);
            }
        });
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
selectClass.setVisibility(View.GONE);
selectedClassdata = myClasses.get(i);
                if(selectedExamData != null && selectedClassdata != null){
                    findMyResult()  ;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
selectClass.setVisibility(View.INVISIBLE);
classSpinner.setVisibility(View.GONE);
            }
        });
    }

    private void findMyResult() {
        Integer selectedPos = null;
        for(int i = 0 ; i < examsList.size(); i++){
            if(examsList.get(i).id.equals(selectedExamData.id) && examsList.get(i).classid.equals(selectedClassdata.id)){
               selectedPos = i;
            }
        }
        if(selectedPos == null){
          resultDataLayout.setVisibility(View.GONE);
          NodataLayout.setVisibility(View.VISIBLE);
        }
        else{
            setData(selectedPos);
            resultDataLayout.setVisibility(View.VISIBLE);
            NodataLayout.setVisibility(View.GONE);
        }
    }

    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
        examSearchLayout = root.findViewById(R.id.examNameSelect);
        classSerachLayout = root.findViewById(R.id.classNameSelect);
        searchBtnLayout = root.findViewById(R.id.searchBtnLayout);
        resultDataLayout = root.findViewById(R.id.resultDataLayout);
        subjectsList = root.findViewById(R.id.subjectList);
        subjectsList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        examName = root.findViewById(R.id.examName);
        className = root.findViewById(R.id.className);
        examStartDate = root.findViewById(R.id.startdate);
        examEndDate = root.findViewById(R.id.endDate);
        totalMarks = root.findViewById(R.id.totalmarks);
        securedMarks = root.findViewById(R.id.securedmarks);
        resultDataLayout.setVisibility(View.GONE);
        NodataLayout = root.findViewById(R.id.noDataLayout);
        searchLayout = root.findViewById(R.id.serachLayout);
        status = root.findViewById(R.id.examStatus);
        backBtn.setOnClickListener(this);
        classSpinner = root.findViewById(R.id.classSpinner);
        examSpinner = root.findViewById(R.id.examSpinner);
        searchBtnLayout.setOnClickListener(this);
        examSearchLayout.setOnClickListener(this);
        classSerachLayout.setOnClickListener(this);
        selectClass = root.findViewById(R.id.selectClass);
        selectExam = root.findViewById(R.id.selectExam);
examSpinner.setVisibility(View.GONE);
classSpinner.setVisibility(View.GONE);
        DropDownData obj1 = new DropDownData("1","Annual Exam");
        DropDownData obj2 = new DropDownData("2","Half-Yearly Exams");
        DropDownData obj3 = new DropDownData("3","Quarterly-Exams");
        DropDownData obj4 = new DropDownData("4","Unit-1");
        DropDownData obj5 = new DropDownData("5","Unit-2");
        DropDownData obj6 = new DropDownData("6","Unit-3");
        myExams.add(obj1);
        myExams.add(obj2);
        myExams.add(obj3);
        myExams.add(obj4);
        myExams.add(obj5);
        myExams.add(obj6);
        DropDownCustomAdapter myDropDownExamAdapter = new DropDownCustomAdapter(getContext(),myExams);
        examSpinner.setAdapter(myDropDownExamAdapter);

        DropDownData obj7 = new DropDownData("1","10th");
        DropDownData obj8 = new DropDownData("2","8th");
        DropDownData obj9 = new DropDownData("3","6th");
        myClasses.add(obj7);
        myClasses.add(obj8);
        myClasses.add(obj9);
DropDownCustomAdapter myClassAdapter = new DropDownCustomAdapter(getContext(),myClasses);
classSpinner.setAdapter(myClassAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn : {
                getFragmentManager().popBackStack();
            }
            break;
            case R.id.examNameSelect : {
                examSpinner.performClick();
                examSpinner.setSelection(-1);
                examSpinner.setVisibility(View.VISIBLE);
                selectExam.setVisibility(View.GONE);
            }
            break;
            case R.id.classNameSelect: {
                classSpinner.performClick();
                classSpinner.setSelection(-1);
                classSpinner.setVisibility(View.VISIBLE);
//                classSpinner.performClick();
                selectClass.setVisibility(View.GONE);
            }
            break;
        }
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
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void setData(Integer selectedPos) {
        examName.setText(examsList.get(selectedPos).examName);
        className.setText(examsList.get(selectedPos).className);
        examStartDate.setText(examsList.get(selectedPos).startDate);
        examEndDate.setText(examsList.get(selectedPos).endDate);
        totalMarks.setText(examsList.get(selectedPos).TotalMarks);
        securedMarks.setText(examsList.get(selectedPos).secured);
        //status.setText(examsList.get(0).examStatus);
        ResultSubjectsAdapter myAdapter = new ResultSubjectsAdapter(getContext(),examsList.get(0).subjects);
        subjectsList.setAdapter(myAdapter);
    }

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
}