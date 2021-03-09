package com.cts.ui.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cts.Helper.Utilities;
import com.cts.Models.AttendanceResponse;
import com.cts.R;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalenderDateAdapter extends RecyclerView.Adapter<CalenderDateAdapter.ViewHolder> {
Context mContext;
ArrayList<AttendanceResponse> myAttendancedData = new ArrayList<>();
onItemClickListener itemClickListener ;

public CalenderDateAdapter(Context context, ArrayList<AttendanceResponse> myData, onItemClickListener listener){
    mContext = context;
    myAttendancedData = myData;
    itemClickListener = listener;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_calender_date, parent, false);
        return new CalenderDateAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        AttendanceResponse obj = myAttendancedData.get(position);
        try {
            Date myDate =  Utilities.stringToDateConvertor("yyyy-MM-dd",obj.date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(myDate);
            holder.dateText.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            if(obj.isCurrentMonth){
                if(obj.isCurrentDay){
                    holder.dateLayout.setBackground(mContext.getResources().getDrawable(R.drawable.today_date_bg));
                    holder.dateText.setTextColor(mContext.getResources().getColor(R.color.appThemeColor));
                }
                else {
                    holder.dateLayout.setBackgroundColor(mContext.getResources().getColor(R.color.appThemeOpacity));
                    holder.dateText.setTextColor(mContext.getResources().getColor(R.color.appThemeColor));
                }
            }
            else{
                holder.dateLayout.setBackgroundColor(mContext.getResources().getColor(R.color.light_grey));
                holder.dateText.setTextColor(mContext.getResources().getColor(R.color.unselectedDateColor));
            }
            if(obj.isSelectedDay){
                holder.dateLayout.setBackgroundColor(mContext.getResources().getColor(R.color.appThemeColor));
                holder.dateText.setTextColor(mContext.getResources().getColor(R.color.white));
            }
            if(obj.isPresent){
                holder.presentView.setVisibility(View.VISIBLE);
            }
            else{
                holder.presentView.setVisibility(View.GONE);
            }
            if(obj.isAbscent){
                holder.absentView.setVisibility(View.VISIBLE);
            }
            else{
                holder.absentView.setVisibility(View.GONE);
            }
            if(obj.isLate){
                holder.lateView.setVisibility(View.VISIBLE);
            }
            else{
                holder.lateView.setVisibility(View.GONE);
            }
            if(obj.isHalfDay){
                holder.holidayView.setVisibility(View.VISIBLE);
            }
            else{
                holder.holidayView.setVisibility(View.GONE);
            }
            if(obj.isHoliday){
                holder.halfDayView.setVisibility(View.VISIBLE);
            }
            else{
                holder.halfDayView.setVisibility(View.GONE);
            }
            holder.dateLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        Date todaysDate = Utilities.stringToDateConvertor("yyyy-MM-dd",Utilities.dateToStringConvertor("yyyy-MM-dd",new Date()));
                        Date SelectedDate = Utilities.stringToDateConvertor("yyyy-MM-dd",myAttendancedData.get(position).date);
                    if(todaysDate.compareTo(SelectedDate) >= 0 && myAttendancedData.get(position).isCurrentMonth){
                        itemClickListener.onItemClick(view,position);
                    }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                }
            });

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return myAttendancedData.size();
    }

    public interface  onItemClickListener {
        void onItemClick(View view , Integer position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dateText;
        View presentView,absentView,lateView,holidayView,halfDayView;
        RelativeLayout dateLayout;

        ViewHolder(View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.dateText);
            presentView = itemView.findViewById(R.id.presentLayout);
            absentView = itemView.findViewById(R.id.abscentLayout);
            lateView = itemView.findViewById(R.id.lateLayout);
            holidayView = itemView.findViewById(R.id.holidayLayout);
            halfDayView = itemView.findViewById(R.id.halfLayout);
            dateLayout = itemView.findViewById(R.id.dateLayout);
        }

    }
    public void updateList(ArrayList<AttendanceResponse> myData){
    myAttendancedData = myData;
    notifyDataSetChanged();
    }
}
