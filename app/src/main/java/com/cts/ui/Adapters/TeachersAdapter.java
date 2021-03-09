package com.cts.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cts.Models.TeachersResponse;
import com.cts.R;

import java.util.ArrayList;

public class TeachersAdapter extends RecyclerView.Adapter<TeachersAdapter.ViewHolder> {
Context mContext;
ArrayList<TeachersResponse> myTeachersList = new ArrayList<>();

public  TeachersAdapter(Context context , ArrayList<TeachersResponse> myData){
    this.mContext = context;
    this.myTeachersList = myData;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_teacher, parent, false);
        return new TeachersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeachersResponse obj = myTeachersList.get(position);
        holder.name.setText(obj.teacherName);
        holder.subject.setText(obj.subjectName);
        holder.phone.setText(obj.phone);
        holder.email.setText(obj.email);
    }

    @Override
    public int getItemCount() {
        return myTeachersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView teacherImage;
        TextView name,subject,phone,email;

        ViewHolder(View itemView) {
            super(itemView);
            teacherImage = itemView.findViewById(R.id.teacherImg);
            name = itemView.findViewById(R.id.teacherName);
            subject = itemView.findViewById(R.id.subjectName);
            phone = itemView.findViewById(R.id.phnNumber);
            email = itemView.findViewById(R.id.email);
        }

    }
}
