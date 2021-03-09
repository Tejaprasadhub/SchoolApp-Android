package com.cts.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cts.Models.Exams;
import com.cts.R;

import java.util.ArrayList;

public class AcademicsAdapter extends RecyclerView.Adapter<AcademicsAdapter.ViewHolder> {
    Context mContext;
    ArrayList<Exams> myAcademicData ;
    Boolean isScheduledExam = false;
    public AcademicsAdapter(Context context, ArrayList<Exams> examList){
        mContext = context;
        myAcademicData = examList;
    }
    public AcademicsAdapter(Context context, ArrayList<Exams> examList,Boolean isScheduled){
        mContext = context;
        myAcademicData = examList;
        isScheduledExam = isScheduled;
    }
    @NonNull
    @Override
    public AcademicsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_academic, parent, false);
        return new AcademicsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AcademicsAdapter.ViewHolder holder, int position) {
        Exams myObj = this.myAcademicData.get(position);
        if(myObj.className != "" && myObj.className != null){
            holder.classLayout.setVisibility(View.GONE);
            holder.className.setText(myObj.className);
        }
        else{
            holder.classLayout.setVisibility(View.GONE);
        }
        if(isScheduledExam == true){
            holder.DateLayout.setVisibility(View.VISIBLE);
        }
        else{
            holder.DateLayout.setVisibility(View.GONE);
        }
        if(myObj.startDate != "" && myObj.startDate != null){
            holder.startDate.setText(myObj.startDate);
        }
        else{
            holder.startDate.setText(" - ");
        }
        if(myObj.endDate != "" && myObj.endDate != null){
            holder.endDate.setText(myObj.endDate);
        }
        else{
            holder.endDate.setText(" - ");
        }
        holder.examName.setText(myObj.examName);
        if(isScheduledExam ==true){
            holder.securedOrTotalHeading.setText("Total Marks");
            holder.marks.setText(myObj.TotalMarks);
        }
        else{
            holder.securedOrTotalHeading.setText("Secured Marks");
            holder.marks.setText(myObj.secured);
        }

    }

    @Override
    public int getItemCount() {
        return myAcademicData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView className,examName,marks,startDate,endDate,securedOrTotalHeading;
        RelativeLayout viewMore;
LinearLayout classLayout,DateLayout;
        ViewHolder(View itemView) {
            super(itemView);
            className = itemView.findViewById(R.id.className);
            examName = itemView.findViewById(R.id.examName);
            marks = itemView.findViewById(R.id.marks);
            viewMore = itemView.findViewById(R.id.viewmore);
            startDate = itemView.findViewById(R.id.startdate);
            endDate = itemView.findViewById(R.id.endDate);
            classLayout = itemView.findViewById(R.id.classlayout);
            DateLayout = itemView.findViewById(R.id.dateLayout);
            securedOrTotalHeading = itemView.findViewById(R.id.secured_or_total);
        }


    }
}
