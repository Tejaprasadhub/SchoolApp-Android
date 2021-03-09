package com.cts.ui.Fragments.ParentSide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.cts.Helper.Utilities;
import com.cts.Models.AttendanceResponse;
import com.cts.R;
import com.cts.ui.Adapters.CalenderDateAdapter;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class AttendanceFragment extends Fragment implements View.OnClickListener {
    ImageButton backBtn,previousMonthBtn,nextMonthBtn;
    TextView currentMonth,totalWorkingDays,notMarkedDays,presentDays,abscentDays,holidays,halfDays,late,weekDayText,dateText,timingText,infoText,reasonText;
    RelativeLayout popUpLayout;
    int CurrentYear;
    int CurrentMonth;
    int CurrentDay;
    Button closePopUpBtn ;
    Calendar calendar;

RecyclerView myCalenderView;
CalenderDateAdapter adapter;
    String PreviousMonthLastDate,CurrentMonthStartDate,CurrentMonthEndDate,NextMonthStartDate;
    String months[] = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
    ArrayList<AttendanceResponse> myAttendanceData = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_attendance, container, false);
        init(root);
        renderCalender();
        return  root;
    }

    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
        previousMonthBtn = root.findViewById(R.id.previousMonth);
        nextMonthBtn = root.findViewById(R.id.nextMonth);
        currentMonth = root.findViewById(R.id.month_and_year);
        myCalenderView = root.findViewById(R.id.myCalenderView);
        myCalenderView.setLayoutManager(new GridLayoutManager(getContext(), 7));
        calendar = Calendar.getInstance(TimeZone.getDefault());
        CurrentYear = calendar.get(Calendar.YEAR);
        CurrentMonth = calendar.get(Calendar.MONTH);
        CurrentDay = calendar.get(Calendar.DAY_OF_MONTH);
        weekDayText = root.findViewById(R.id.weekDay);
        dateText = root.findViewById(R.id.dateText);
        timingText = root.findViewById(R.id.timings);
        infoText = root.findViewById(R.id.info);
        reasonText = root.findViewById(R.id.reason);
        totalWorkingDays = root.findViewById(R.id.totalWorkingdays);
        notMarkedDays = root.findViewById(R.id.attendanceNotMarked);
        presentDays = root.findViewById(R.id.presentDays);
        abscentDays = root.findViewById(R.id.abscentDays);
        late = root.findViewById(R.id.lateDays);
        halfDays = root.findViewById(R.id.halfDays);
        holidays = root.findViewById(R.id.holidays);
        popUpLayout = root.findViewById(R.id.popupLayout);
        popUpLayout.setVisibility(View.GONE);
        Log.e("Date" , CurrentYear + " " + CurrentMonth + " " + CurrentDay);
        backBtn.setOnClickListener(this);
        previousMonthBtn.setOnClickListener(this);
        nextMonthBtn.setOnClickListener(this);
closePopUpBtn = root.findViewById(R.id.okBtn);
closePopUpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn : {
                getFragmentManager().popBackStack();
            }
            break;
            case R.id.previousMonth : {
                CurrentMonth = CurrentMonth -1;
                if(CurrentMonth < 0){
                    CurrentYear = CurrentYear -1;
                    CurrentMonth = months.length -1;
                }

                renderCalender();
            }
            break;
            case R.id.nextMonth : {
                CurrentMonth = CurrentMonth + 1;
                if(CurrentMonth == months.length ){
                    CurrentYear = CurrentYear + 1;
                    CurrentMonth = 0;
                }
                renderCalender();
            }
            break;
            case R.id.okBtn : {
                popUpLayout.setVisibility(View.GONE);
            }
            default:{

            }
        }
    }

    private void renderCalender()  {
        myAttendanceData = new ArrayList<>();
        currentMonth.setText(months[CurrentMonth] + " " + CurrentYear);
        CurrentMonthStartDate =  CurrentYear + "-" + (CurrentMonth + 1) + "-1"  ;
        NextMonthStartDate =  CurrentYear + "-" + (CurrentMonth + 2) + "-1";
        Log.e("start_date" , CurrentMonthStartDate);
        try {
            Date currentMonthstartAt = Utilities.stringToDateConvertor("yyyy-MM-dd",CurrentMonthStartDate) ;

            Date NxtMonthStartDate = Utilities.stringToDateConvertor("yyyy-MM-dd",NextMonthStartDate);
            calendar.setTime(NxtMonthStartDate);
            calendar.add(Calendar.DAY_OF_MONTH , -1);
            //calendar.add(Calendar.MONTH, -1);
            Date currentMonthEndAt = calendar.getTime();
            CurrentMonthEndDate = Utilities.dateToStringConvertor("yyyy-MM-dd",calendar.getTime()) ;
            int weekDay = Utilities.getWeekDay(currentMonthstartAt);

            for(int i= 1; i <= weekDay ; i++){
                calendar.setTime(currentMonthstartAt);
                calendar.add(Calendar.DAY_OF_MONTH, 0-i);
               // calendar.add(Calendar.MONTH , -1);
                AttendanceResponse obj = new AttendanceResponse();
                obj.date = Utilities.dateToStringConvertor("yyyy-MM-dd",calendar.getTime());
                myAttendanceData.add(0,obj);
            }
            calendar.setTime(currentMonthEndAt);
            int totalDays = calendar.get(Calendar.DAY_OF_MONTH);
            Date todaysDate = new Date();
            String Todaysdate = Utilities.dateToStringConvertor("yyyy-MM-dd",todaysDate);
            for(int i=0; i < totalDays; i++){
                calendar.setTime(currentMonthstartAt);
                calendar.add(Calendar.DAY_OF_MONTH,i);
                AttendanceResponse obj = new AttendanceResponse();
                obj.date = Utilities.dateToStringConvertor("yyyy-MM-dd",calendar.getTime());
                obj.isCurrentMonth = true;
                if(Todaysdate.equals(obj.date)){
                    obj.isCurrentDay = true;
                }
                myAttendanceData.add(obj);
            }

            int enddateWeekDay = Utilities.getWeekDay(currentMonthEndAt);
            if(enddateWeekDay < 6){
                for(int i=0;i< (6-enddateWeekDay); i++){
                    calendar.setTime(NxtMonthStartDate);
                    calendar.add(Calendar.DAY_OF_MONTH,i);
                    AttendanceResponse obj = new AttendanceResponse();
                    obj.date = Utilities.dateToStringConvertor("yyyy-MM-dd",calendar.getTime());
                    myAttendanceData.add(obj);
                }
            }


            Log.e("data of calender" , myAttendanceData.toString());
            if(adapter == null){
                adapter = new CalenderDateAdapter(getContext(), myAttendanceData, new CalenderDateAdapter.onItemClickListener() {
                    @Override
                    public void onItemClick(View view, Integer position) {
                       Log.e("clicked obj" , myAttendanceData.get(position).date);
                       for(int i = 0 ; i< myAttendanceData.size(); i ++){
                           if(position == i){
                               myAttendanceData.get(i).isSelectedDay = true;
                           }
                           else{
                               myAttendanceData.get(i).isSelectedDay = false;
                           }
                       }
                       adapter.updateList(myAttendanceData);
                       popUpLayout.setVisibility(View.VISIBLE);
                       dateText.setText(myAttendanceData.get(position).date);
                    }
                });
                myCalenderView.setAdapter(adapter);
            }
            else{
                adapter.updateList(myAttendanceData);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}