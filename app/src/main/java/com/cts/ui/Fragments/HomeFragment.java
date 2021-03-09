package com.cts.ui.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.cts.Helper.Utilities;
import com.cts.Models.FeesCategory;
import com.cts.R;
import com.cts.ui.Adapters.ChildPicsAdapter;
import com.cts.ui.Adapters.HomePageAdapter;
import com.cts.ui.Fragments.ParentSide.AttendanceFragment;
import com.cts.ui.Fragments.ParentSide.FeesFragment;
import com.cts.ui.Fragments.ParentSide.HomeworkFragment;
import com.cts.ui.Fragments.ParentSide.TeacherFragment;
import com.cts.ui.Fragments.ParentSide.TimeTableFragment;
import com.cts.ui.Fragments.TeacherSide.StudentFragment;
import com.cts.ui.Fragments.TeacherSide.TeacherHomeworkFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment  {
    TextView userName;
    RecyclerView myOptionList,myChildList;
    ArrayList<FeesCategory> parentOptions  = new ArrayList<>();
    ArrayList<FeesCategory> teacherOptions  = new ArrayList<>();
    SharedPreferences sharedPreferences;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initComponents(root);
        return root;
    }



    private void initComponents(View root) {
        parentOptions = new ArrayList<>();
        teacherOptions = new ArrayList<>();
        userName = root.findViewById(R.id.userName);
        myOptionList = root.findViewById(R.id.optionsList);
        myOptionList.setLayoutManager(new GridLayoutManager(getContext(), 3));

        sharedPreferences = getActivity().getSharedPreferences(Utilities.My_login_pref, Context.MODE_PRIVATE);

        FeesCategory obj1 = new FeesCategory("My Child",R.mipmap.student,false);
        FeesCategory obj2 = new FeesCategory("fees",R.mipmap.wallet,false);
        FeesCategory obj3 = new FeesCategory("Exams",R.mipmap.grade,false);
        FeesCategory obj4 = new FeesCategory("TimeTable",R.mipmap.documents,false);
        FeesCategory obj5 = new FeesCategory("HomeWork",R.mipmap.survey,false);
        FeesCategory obj6 = new FeesCategory("Attendance",R.mipmap.calendar,false);
        FeesCategory obj7 = new FeesCategory("Teacher",R.mipmap.teacher,false);
        parentOptions.add(obj1);
        parentOptions.add(obj2);
        parentOptions.add(obj3);
        parentOptions.add(obj4);
        parentOptions.add(obj5);
        parentOptions.add(obj6);
        parentOptions.add(obj7);

        FeesCategory obj8 = new FeesCategory("Students",R.mipmap.student,false);
        FeesCategory obj9 = new FeesCategory("Academics",R.mipmap.academic,false);
        FeesCategory obj10 = new FeesCategory("HomeWork",R.mipmap.survey,false);
        FeesCategory obj11 = new FeesCategory("Exams",R.mipmap.exam_icon,false);
        FeesCategory obj12 = new FeesCategory("Attendance",R.mipmap.calendar,false);
        FeesCategory obj13 = new FeesCategory("Leave",R.mipmap.calendar,false);
        FeesCategory obj14 = new FeesCategory("Contents",R.mipmap.documents,false);
        FeesCategory obj15 = new FeesCategory("NoticeBoard",R.mipmap.notesboard_active,false);
        teacherOptions.add(obj8);
        teacherOptions.add(obj9);
        teacherOptions.add(obj10);
        teacherOptions.add(obj11);
        teacherOptions.add(obj12);
        teacherOptions.add(obj13);
        teacherOptions.add(obj14);
        teacherOptions.add(obj15);

        ArrayList<FeesCategory> displayList  = new ArrayList<>();
        if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Parent) ){
            displayList = parentOptions;
        }
        else if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Teacher)){
            displayList = teacherOptions;
        }

        HomePageAdapter adapter = new HomePageAdapter(getContext(), displayList, new HomePageAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, Integer position) {
                switch (position){
                    case 0:{
                        if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Parent) ){
                            MyChildFragment myChildFragment = new MyChildFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.framelayout, myChildFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Teacher)){
                            StudentFragment studentFragment = new StudentFragment() ;
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.framelayout, studentFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }

                    }
                    break;
                    case 1:{

                        if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Parent) ){
                            FeesFragment feesFragment = new FeesFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.framelayout, feesFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Teacher)){

                        }

                    }
                    break;
                    case 2: {

                        if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Parent) ){
                            ExamsFragment examsFragment = new ExamsFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.framelayout, examsFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Teacher)){
                            TeacherHomeworkFragment teacherHomeworkFragment = new TeacherHomeworkFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.framelayout, teacherHomeworkFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }

                    }
                    break;
                    case 3: {
                        if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Parent) ){
                            TimeTableFragment timeTableFragment = new TimeTableFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.framelayout, timeTableFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Teacher)){

                        }

                    }
                    break;
                    case 4: {
                        if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Parent) ){

                            HomeworkFragment homeworkFragment = new HomeworkFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.framelayout, homeworkFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Teacher)){

                        }

                    }
                    break;
                    case 5: {
                        if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Parent) ){

                            AttendanceFragment attendanceFragment = new AttendanceFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.framelayout, attendanceFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Teacher)){

                        }

                    }
                    break;
                    case 6: {
                        if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Parent) ){
                            TeacherFragment teacherFragment = new TeacherFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.framelayout, teacherFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else if(sharedPreferences.getString(Utilities.userType, "").equals(Utilities.Teacher)){

                        }

                    }
                    break;
                    default: {

                    }
                }
            }
        });
        myOptionList.setAdapter(adapter);
        myChildList = root.findViewById(R.id.childList);
        myChildList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        myChildList.setAdapter(new ChildPicsAdapter(getContext()));

    }



}