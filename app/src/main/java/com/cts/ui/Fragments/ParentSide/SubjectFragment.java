package com.cts.ui.Fragments.ParentSide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cts.R;
import com.cts.ui.Adapters.ChaptersAdapter;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


public class SubjectFragment extends Fragment{
ImageButton backBtn;
ImageView teacherImg;
TextView heading,teacherName,subjectName,phone,email;
HorizontalCalendar calenderView;
    RecyclerView chapters;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_subject, container, false);
        init(root);
        initListeners();
        return root;
    }

    private void initListeners() {
        calenderView.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
    }


    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
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

        chapters = root.findViewById(R.id.chapterList);
        chapters.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        chapters.setAdapter(new ChaptersAdapter(getContext()));

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
    }


}