package com.cts.ui.Fragments.TeacherSide;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.cts.Models.MyChildInfo;
import com.cts.R;
import com.cts.ui.Adapters.MyChildCardsAdapter;

import java.util.ArrayList;


public class StudentFragment extends Fragment implements  View.OnClickListener{

ImageButton backBtn,searchBtn;
CardView searchLayout;
RecyclerView myChildList;
Boolean isSearchOpen = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_student, container, false);
        init(root);
        return  root;
    }

    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
        searchBtn = root.findViewById(R.id.search);
        searchBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
        searchLayout = root.findViewById(R.id.searchLayout);
        myChildList = root.findViewById(R.id.studentList);
        myChildList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        ArrayList<MyChildInfo> myData = new ArrayList<>();
        MyChildInfo obj1 = new MyChildInfo();
        MyChildInfo obj2  = new MyChildInfo();
        myData.add(obj1);
        myData.add(obj2);
        myChildList.setAdapter(new MyChildCardsAdapter(getContext(),myData));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn : {
                getFragmentManager().popBackStack();
            }
            break;
            case R.id.search : {
                if(isSearchOpen == false){
                    searchLayout.setVisibility(View.VISIBLE);
                    searchBtn.setImageResource(R.mipmap.search_minus);
                    isSearchOpen = true;
                }
                else{
                    searchLayout.setVisibility(View.GONE);
                    searchBtn.setImageResource(R.mipmap.search);
                    isSearchOpen = false;
                }
            }
            break;
            default:{

            }
        }
    }
}