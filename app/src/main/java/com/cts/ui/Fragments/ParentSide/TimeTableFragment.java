package com.cts.ui.Fragments.ParentSide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cts.Models.Exams;
import com.cts.Models.TimeTableResponse;
import com.cts.R;
import com.cts.ui.Adapters.TimeTableAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class TimeTableFragment extends Fragment {
HorizontalCalendar calenderView;
ImageButton bckBtn;
RecyclerView timeTableRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_time_table, container, false);
          init(root);
          initListeners();
          readJSONFromAsset();
        return root;
    }

    private void initListeners() {
        calenderView.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }
        });
        bckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
getFragmentManager().popBackStack();
            }
        });
    }

    private void init(View root) {
        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        calenderView = new HorizontalCalendar.Builder(root, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(7)
                .configure()    // starts configuration.
                .formatTopText("EEE")       // default to "MMM".
                .formatMiddleText("dd")    // default to "dd".
                .formatBottomText("MMM")    // default to "EEE".
                .end()
                .defaultSelectedDate(Calendar.getInstance())
                .build();

        bckBtn = root.findViewById(R.id.backBtn);
        timeTableRecyclerView = root.findViewById(R.id.timeTableList);
timeTableRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("TimeTable.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<TimeTableResponse> myData = objectMapper.readValue(json, new TypeReference<ArrayList<TimeTableResponse>>() {});
            TimeTableAdapter myAdapter = new TimeTableAdapter(getContext(),myData);
            timeTableRecyclerView.setAdapter(myAdapter);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}