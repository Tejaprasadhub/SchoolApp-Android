package com.cts.ui.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cts.Models.TimeTableResponse;
import com.cts.R;

import java.util.ArrayList;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.ViewHolder> {
Context mContext;
ArrayList<TimeTableResponse> timeTableData = new ArrayList<>();
  public TimeTableAdapter(Context context,ArrayList<TimeTableResponse> myData){
      mContext = context;
      timeTableData = myData;
  }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_time_table, parent, false);
        return new TimeTableAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TimeTableResponse obj = timeTableData.get(position);
        holder.startTime.setText(obj.StartTime);
        holder.endTime.setText(obj.EndTime);
        holder.subject.setText(obj.subjectName);
        holder.exp.setText(obj.Exp + "Yrs");
        holder.teacher.setText(obj.TeacherName);
        if(obj.isPractical){
        holder.practicalayout.setBackgroundColor(Color.parseColor("#4d168b"));
        }
        else{
            holder.practicalayout.setBackgroundColor(Color.parseColor("#B69BD5"));
        }
        if(obj.isTheory){
            holder.TheoryLayout.setBackgroundColor(Color.parseColor("#4d168b"));
        }
        else{
            holder.TheoryLayout.setBackgroundColor(Color.parseColor("#B69BD5"));
        }
    }

    @Override
    public int getItemCount() {
        return timeTableData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView startTime,endTime,subject,exp,teacher;
        RelativeLayout practicalayout,TheoryLayout;

        ViewHolder(View itemView) {
            super(itemView);
            startTime = itemView.findViewById(R.id.startTime);
            endTime = itemView.findViewById(R.id.endTime);
            subject = itemView.findViewById(R.id.subjectName);
            exp = itemView.findViewById(R.id.exp);
            teacher = itemView.findViewById(R.id.teacherName);
            practicalayout = itemView.findViewById(R.id.practicalLayout);
            TheoryLayout = itemView.findViewById(R.id.theoryLayout);
        }

    }
}
