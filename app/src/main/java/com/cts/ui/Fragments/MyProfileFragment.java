package com.cts.ui.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cts.Models.MyChildInfo;
import com.cts.R;
import com.cts.ui.Adapters.MyChildCardsAdapter;

import java.util.ArrayList;

public class MyProfileFragment extends Fragment {
ImageButton backBtn;

TextView fullNameTV,emailTv,phoneTv,genderTv,religionTv,nationalityTv,addressTv,headingText,personaldetailsHeading;
EditText fullNameET,emailEt,phoneEt,religionEt,nationalityEt,addressEt;
RelativeLayout myChildDetailsLayout;
RecyclerView myChildList;
Button saveBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        init(root);
        setAndLoadUI();
        initListeners();
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

    private void setAndLoadUI() {
String caller = getArguments().getString("caller");
if(caller.equals("view")){
    fullNameTV.setVisibility(View.VISIBLE);
    emailTv.setVisibility(View.VISIBLE);
    phoneTv.setVisibility(View.VISIBLE);
    genderTv.setVisibility(View.VISIBLE);
    religionTv.setVisibility(View.VISIBLE);
    nationalityTv.setVisibility(View.VISIBLE);
    addressTv.setVisibility(View.VISIBLE);

    fullNameET.setVisibility(View.GONE);
    emailEt.setVisibility(View.GONE);
    phoneEt.setVisibility(View.GONE);
    religionEt.setVisibility(View.GONE);
    nationalityEt.setVisibility(View.GONE);
    addressEt.setVisibility(View.GONE);
saveBtn.setVisibility(View.GONE);
    headingText.setText("My Profile");
    personaldetailsHeading.setVisibility(View.VISIBLE);
    myChildDetailsLayout.setVisibility(View.VISIBLE);
}
else if(caller.equals("edit")){
    fullNameTV.setVisibility(View.GONE);
    emailTv.setVisibility(View.GONE);
    phoneTv.setVisibility(View.GONE);
    religionTv.setVisibility(View.GONE);
    nationalityTv.setVisibility(View.GONE);
    genderTv.setVisibility(View.VISIBLE);
    addressTv.setVisibility(View.GONE);

    fullNameET.setVisibility(View.VISIBLE);
    emailEt.setVisibility(View.VISIBLE);
    phoneEt.setVisibility(View.VISIBLE);
    religionEt.setVisibility(View.VISIBLE);
    nationalityEt.setVisibility(View.VISIBLE);
    addressEt.setVisibility(View.VISIBLE);
    headingText.setText("Edit Profile");
    saveBtn.setVisibility(View.VISIBLE);
    fullNameET.setFocusable(true);
    getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    personaldetailsHeading.setVisibility(View.GONE);
    myChildDetailsLayout.setVisibility(View.GONE);
}
    }

    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
        fullNameET = root.findViewById(R.id.fullNameET);
        emailEt = root.findViewById(R.id.emailET);
        phoneEt = root.findViewById(R.id.phoneET);
        genderTv = root.findViewById(R.id.genderTv);
        religionEt = root.findViewById(R.id.religionEt);
        nationalityEt = root.findViewById(R.id.nationalityEt);
        addressEt = root.findViewById(R.id.addressEt);
        fullNameTV = root.findViewById(R.id.fullNameTv);
        emailTv = root.findViewById(R.id.emailTv);
        phoneTv = root.findViewById(R.id.phoneTv);
        religionTv = root.findViewById(R.id.religionTv);
        nationalityTv = root.findViewById(R.id.nationalityTv);
        addressTv = root.findViewById(R.id.addressTv);
        saveBtn = root.findViewById(R.id.saveBtn);
        headingText = root.findViewById(R.id.headingText);
        personaldetailsHeading = root.findViewById(R.id.personalDetailsHeading);
        myChildDetailsLayout = root.findViewById(R.id.childLayout);
        myChildList = root.findViewById(R.id.myChildList);
        myChildList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        ArrayList<MyChildInfo> myData = new ArrayList<>();
        MyChildInfo obj1 = new MyChildInfo();
        MyChildInfo obj2  = new MyChildInfo();
        myData.add(obj1);
        myData.add(obj2);
        myChildList.setAdapter(new MyChildCardsAdapter(getContext(),myData));

    }
}