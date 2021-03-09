package com.cts.ui.Fragments.TeacherSide;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cts.R;

import java.util.Calendar;


public class AddHomeWorkFragment extends Fragment implements View.OnClickListener {
    ImageButton backBtn,removeFileBtn;
    LinearLayout selectClassBtn,selectSectionBtn,selectSubjectBtn,assignDateBtn,submissionDateBtn,uploadFileBtn,uploadedFileLayout;
    TextView classSelected,sectionSelected,subjectSelected,assignDate,submissionDate,selectedFileName;
    EditText homeworkTitle,homeworkDesc;
    Button submitBtn;
    public static final int PICKFILE_RESULT_CODE = 1;
    private Uri fileUri;
    private String filePath;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_add_home_work, container, false);
        init(root);
        return root;
    }

    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
        selectClassBtn = root.findViewById(R.id.classNameSelect);
        selectSectionBtn = root.findViewById(R.id.sectionSelect);
        selectSubjectBtn = root.findViewById(R.id.selectSubjectLayout);
        assignDateBtn = root.findViewById(R.id.assignDate);
        submissionDateBtn = root.findViewById(R.id.submitDate);
        uploadFileBtn = root.findViewById(R.id.uploadBtnLayout);
        uploadedFileLayout = root.findViewById(R.id.selectFileLayout);
        classSelected= root.findViewById(R.id.selectClass);
        sectionSelected = root.findViewById(R.id.selectSec);
        subjectSelected = root.findViewById(R.id.selectSubject);
        assignDate = root.findViewById(R.id.selectAssignDate);
        submissionDate = root.findViewById(R.id.selectSubmitDate);
        homeworkTitle = root.findViewById(R.id.homeworkTitle);
        homeworkDesc = root.findViewById(R.id.desc);
        selectedFileName = root.findViewById(R.id.selectedFile);
        submitBtn = root.findViewById(R.id.submitBtn);
        removeFileBtn = root.findViewById(R.id.removeFile);
        submitBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
        selectClassBtn.setOnClickListener(this);
        selectSectionBtn.setOnClickListener(this);
        selectSubjectBtn.setOnClickListener(this);
        assignDateBtn.setOnClickListener(this);
        submissionDateBtn.setOnClickListener(this);
        uploadFileBtn.setOnClickListener(this);
        removeFileBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
   switch(view.getId()){
       case R.id.backBtn : {
getFragmentManager().popBackStack();
       }
       break;
       case R.id.classNameSelect : {

       }
       break;
       case R.id.sectionSelect : {

       }
       break;
       case R.id.selectSubjectLayout : {

       }
       break;
       case R.id.assignDate : {
           Calendar myDate = Calendar.getInstance();
           DatePickerDialog myDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
               @Override
               public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                   assignDate.setText(selectedDay + "-" + selectedMonth + "-" + selectedYear);
               }
           }, myDate.get(Calendar.YEAR), myDate.get(Calendar.MONTH), myDate.get(Calendar.DAY_OF_MONTH));
           myDatePickerDialog.show();
       }
       break;
       case R.id.submitDate:{
           Calendar myDate = Calendar.getInstance();
           DatePickerDialog myDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
               @Override
               public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                   submissionDate.setText(selectedDay + "-" + selectedMonth + "-" + selectedYear);
               }
           }, myDate.get(Calendar.YEAR), myDate.get(Calendar.MONTH), myDate.get(Calendar.DAY_OF_MONTH));
           myDatePickerDialog.show();
       }
       break;
       case R.id.uploadBtnLayout:{
           Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
           chooseFile.setType("*/*");
           chooseFile = Intent.createChooser(chooseFile, "Choose a file");
           startActivityForResult(chooseFile, PICKFILE_RESULT_CODE);
       }
       break;
       case R.id.submitBtn : {

       }
       break;
       case R.id.removeFile : {
           uploadedFileLayout.setVisibility(View.GONE);
       }
       break;
       default: {

       }
   }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICKFILE_RESULT_CODE:
                if (resultCode == -1) {
                    fileUri = data.getData();
                    filePath = fileUri.getPath();
                    selectedFileName.setText(filePath);
                    uploadedFileLayout.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

}