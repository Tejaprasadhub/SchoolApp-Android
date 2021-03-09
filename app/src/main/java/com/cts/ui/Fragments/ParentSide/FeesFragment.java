package com.cts.ui.Fragments.ParentSide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cts.Models.FeesCategory;
import com.cts.Models.FeesCategoryData;
import com.cts.R;
import com.cts.ui.Adapters.FeesDataAdapter;
import com.cts.ui.Adapters.HomePageAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FeesFragment extends Fragment implements View.OnClickListener {
ImageButton backtn;
RecyclerView CatgList,CatgListData;
ArrayList<FeesCategory> myFeesCatg = new ArrayList<>();
ArrayList<FeesCategoryData> myFeesCatgData = new ArrayList<>();
HomePageAdapter myAdapter;
FeesDataAdapter catgDataAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_fees, container, false);
        init(root);
        readJSONFromAsset();
        return root;
    }

    private void init(View root) {
       backtn = root.findViewById(R.id.backBtn);
       CatgList = root.findViewById(R.id.catgList);
        CatgList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
       CatgListData = root.findViewById(R.id.catgListData);
        CatgListData.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
       backtn.setOnClickListener(this);
    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("Fees.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            myFeesCatg = objectMapper.readValue(json, new TypeReference<ArrayList<FeesCategory>>() {});
            myFeesCatg.get(0).isSelected = true;
            myFeesCatgData = myFeesCatg.get(0).catgData;
            myAdapter = new HomePageAdapter(getContext(), myFeesCatg, new HomePageAdapter.onItemClickListener() {
                @Override
                public void onItemClick(View view, Integer position) {
                    for(int i=0;i<myFeesCatg.size();i++) {
                        myFeesCatg.get(i).isSelected = false;
                    }
                    myFeesCatg.get(position).isSelected = true;

                    if(CatgList != null){
                         myAdapter.UpdateList(myFeesCatg);
                        if(CatgListData != null){
                            catgDataAdapter.UpdateList(myFeesCatg.get(position).catgData);
                        }
                    }
                }
            });
            CatgList.setAdapter(myAdapter);
            catgDataAdapter = new FeesDataAdapter(getContext(),myFeesCatgData);
            CatgListData.setAdapter(catgDataAdapter);
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
        }
    }
}