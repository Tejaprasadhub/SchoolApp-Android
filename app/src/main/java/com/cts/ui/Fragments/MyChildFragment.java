package com.cts.ui.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cts.Helper.Utilities;
import com.cts.Models.Exams;
import com.cts.Models.MyChildInfo;
import com.cts.R;
import com.cts.ui.Adapters.AcademicsAdapter;
import com.cts.ui.Adapters.GuardianAdapter;
import com.cts.ui.Adapters.MyChildCardsAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MyChildFragment extends Fragment {
LinearLayout personalInactiveBtn,personalActiveBtn,academicInactiveBtn,academicactiveBtn,addressInactiveBtn,addressActiveBtn,guardianActiveBtn,guardianInactiveBtn;
RelativeLayout personalBtnLayout,personalContent,academicBtnLayout,addressBtnLayout,addressContentLayout,guardianLayout,guardianBtnLayout;
RecyclerView examsList,guardianList;
ImageButton back;
ArrayList<Exams> myAcademicList = new ArrayList<>();
    SharedPreferences sharedPreferences;
    Boolean isPersonalDataActive = false,isAcademicDataActive = false , isAddressDataActive = false,isGuardianDataActive = false;
   TextView myHeading;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_my_child, container, false);
        initLayoutComponent(root);
        initListeners();
        readJSONFromAsset();
        return root;
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
            myAcademicList = objectMapper.readValue(json, new TypeReference<ArrayList<Exams>>() {});
            examsList.setAdapter(new AcademicsAdapter(getContext(),myAcademicList));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void initListeners() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        personalBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPersonalDataActive == true){
                    personalInactiveBtn.setVisibility(View.VISIBLE);
                    personalActiveBtn.setVisibility(View.GONE);
                    personalContent.setVisibility(View.GONE);
                    isPersonalDataActive = !isPersonalDataActive;
                }
                else{
                    personalInactiveBtn.setVisibility(View.GONE);
                    personalActiveBtn.setVisibility(View.VISIBLE);
                    personalContent.setVisibility(View.VISIBLE);
                    isPersonalDataActive = !isPersonalDataActive;
                }
            }
        });

        academicBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAcademicDataActive == true){
                    academicactiveBtn.setVisibility(View.GONE);
                    examsList.setVisibility(View.GONE);
                    academicInactiveBtn.setVisibility(View.VISIBLE);
                    isAcademicDataActive = !isAcademicDataActive;
                }
                else{
                    academicactiveBtn.setVisibility(View.VISIBLE);
                    examsList.setVisibility(View.VISIBLE);
                    academicInactiveBtn.setVisibility(View.GONE);
                    isAcademicDataActive = !isAcademicDataActive;
                }
            }
        });

        addressBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAddressDataActive == true){
                    addressInactiveBtn.setVisibility(View.VISIBLE);
                    addressActiveBtn.setVisibility(View.GONE);
                    addressContentLayout.setVisibility(View.GONE);
                    isAddressDataActive = !isAddressDataActive;
                }
                else{
                    addressInactiveBtn.setVisibility(View.GONE);
                    addressActiveBtn.setVisibility(View.VISIBLE);
                    addressContentLayout.setVisibility(View.VISIBLE);
                    isAddressDataActive = !isAddressDataActive;
                }
            }
        });

        guardianBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGuardianDataActive == true){
                    guardianInactiveBtn.setVisibility(View.VISIBLE);
                    guardianActiveBtn.setVisibility(View.GONE);
                    guardianList.setVisibility(View.GONE);
                    isGuardianDataActive = !isGuardianDataActive;
                }
                else{
                    guardianInactiveBtn.setVisibility(View.GONE);
                    guardianActiveBtn.setVisibility(View.VISIBLE);
                    guardianList.setVisibility(View.VISIBLE);
                    isGuardianDataActive = !isGuardianDataActive;
                }
            }
        });

    }

    private void initLayoutComponent(View root) {
        personalBtnLayout = root.findViewById(R.id.personalBtnLayout);
        personalInactiveBtn =root.findViewById(R.id.inactivePersonalLayout);
        personalActiveBtn = root.findViewById(R.id.activePersonalLayout);
        personalContent = root.findViewById(R.id.personalDataContent);
        academicBtnLayout = root.findViewById(R.id.academicBtnLayout);
        academicInactiveBtn = root.findViewById(R.id.inactive_academic_Layout);
        academicactiveBtn = root.findViewById(R.id.active_academic_Layout);
        addressBtnLayout = root.findViewById(R.id.addressBtnLayout);
        back = root.findViewById(R.id.backBtn);
        addressInactiveBtn = root.findViewById(R.id.inactive_address_Layout);
        addressActiveBtn = root.findViewById(R.id.active_address_Layout);
        addressContentLayout = root.findViewById(R.id.addressContentLayout);
        examsList = root.findViewById(R.id.examsList);
        myHeading = root.findViewById(R.id.headingText);
        personalActiveBtn.setVisibility(View.GONE);
        personalContent.setVisibility(View.GONE);

        academicactiveBtn.setVisibility(View.GONE);
        examsList.setVisibility(View.GONE);

        addressActiveBtn.setVisibility(View.GONE);
        addressContentLayout.setVisibility(View.GONE);

        guardianLayout = root.findViewById(R.id.guardianLayout);
        guardianBtnLayout = root.findViewById(R.id.guardianBtnLayout);
        guardianActiveBtn = root.findViewById(R.id.active_guardian_Layout);
        guardianInactiveBtn = root.findViewById(R.id.inactive_guardian_Layout);
        guardianList = root.findViewById(R.id.guardanList);
        examsList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        guardianList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        sharedPreferences = getActivity().getSharedPreferences(Utilities.My_login_pref, Context.MODE_PRIVATE);

        if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Parent) ){
           guardianLayout.setVisibility(View.GONE);
           myHeading.setText("My Child");

        }
        else if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Teacher)){
           guardianLayout.setVisibility(View.VISIBLE);
           myHeading.setText("Student Details");
            ArrayList<MyChildInfo> myData = new ArrayList<>();
            MyChildInfo obj1 = new MyChildInfo();
            myData.add(obj1);
            guardianList.setAdapter(new GuardianAdapter(getContext(),myData));
        }

    }
}