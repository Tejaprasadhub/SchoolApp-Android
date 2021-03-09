package com.cts.ui.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cts.Models.NoticeBoard;
import com.cts.Models.TeachersResponse;
import com.cts.R;
import com.cts.ui.Adapters.NoticeBoardAdapter;
import com.cts.ui.Adapters.TeachersAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class NoticeBoardFragment extends Fragment {
RecyclerView noticeBoardList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_notice_board, container, false);
        init(root);
        readJSONFromAsset();
        return root;
    }

    private void init(View root) {
        noticeBoardList = root.findViewById(R.id.noticeboardList);
        noticeBoardList.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("Notice.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<NoticeBoard> myData = objectMapper.readValue(json, new TypeReference<ArrayList<NoticeBoard>>() {});
            NoticeBoardAdapter myAdapter = new NoticeBoardAdapter(getContext(),myData);
            noticeBoardList.setAdapter(myAdapter);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}