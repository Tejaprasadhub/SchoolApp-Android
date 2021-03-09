package com.cts.ui.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.cts.Models.Subject;
import com.cts.R;

import java.util.ArrayList;

public class ResultSubjectsAdapter extends RecyclerView.Adapter<ResultSubjectsAdapter.ViewHolder> {
    Context mContext;
    ArrayList<Subject> myAcademicData ;
    public ResultSubjectsAdapter(Context context, ArrayList<Subject> examList){
        mContext = context;
        myAcademicData = examList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_subject, parent, false);
        return new ResultSubjectsAdapter.ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
Subject obj = myAcademicData.get(position);
holder.subjectName.setText(obj.name);
holder.totalMarks.setText(obj.total);
holder.securedMarks.setText(obj.secured);
if(obj.examStatus == "P"){
    holder.examStatus.setText("Passed");
    holder.examStatus.setTextColor(mContext.getResources().getColor(R.color.success_text_bg));
}
else if(obj.examStatus == "F"){
    holder.examStatus.setText("Fail");
    holder.examStatus.setTextColor(mContext.getResources().getColor(R.color.fail_text_color));
}
   }

    @Override
    public int getItemCount() {
        return myAcademicData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subjectName,totalMarks,securedMarks,examStatus;

        ViewHolder(View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.subjectName);
            totalMarks = itemView.findViewById(R.id.totalmarks);
            securedMarks = itemView.findViewById(R.id.securedmarks);
            examStatus = itemView.findViewById(R.id.examStatus);
        }

    }
}
