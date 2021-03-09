package com.cts.ui.Fragments.ParentSide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cts.Models.FeesCategory;
import com.cts.R;
import com.cts.ui.Adapters.HomePageAdapter;

import java.util.ArrayList;


public class HomeworkFragment extends Fragment implements View.OnClickListener {
ImageButton backBtn;
RecyclerView mySubjects ;
HomePageAdapter adapter ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_homework, container, false);
        init(root);
        return root;
    }

    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
        mySubjects = root.findViewById(R.id.subjectsList);
        mySubjects.setLayoutManager(new GridLayoutManager(getContext(), 3));
        ArrayList<FeesCategory> displayList  = new ArrayList<>();
        FeesCategory obj1 = new FeesCategory("Telugu",R.mipmap.e,false);
        FeesCategory obj2 = new FeesCategory("Hindi",R.mipmap.e,false);
        FeesCategory obj3 = new FeesCategory("English",R.mipmap.e,false);
        FeesCategory obj4 = new FeesCategory("Maths",R.mipmap.e,false);
        FeesCategory obj5 = new FeesCategory("Science",R.mipmap.e,false);
        FeesCategory obj6 = new FeesCategory("Social",R.mipmap.e,false);
        displayList.add(obj1);
        displayList.add(obj2);
        displayList.add(obj3);
        displayList.add(obj4);
        displayList.add(obj5);
        displayList.add(obj6);

        adapter = new HomePageAdapter(getContext(), displayList, new HomePageAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, Integer position) {
                SubjectFragment subjectFragment = new SubjectFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, subjectFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        mySubjects.setAdapter(adapter);

        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn:{
                getFragmentManager().popBackStack();
            }
            break;
            default:{

            }
        }
    }
}