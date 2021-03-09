package com.cts.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.cts.Models.MyChildInfo;
import com.cts.R;
import com.cts.ui.Fragments.MyChildFragment;

import java.util.ArrayList;


public class MyChildCardsAdapter extends RecyclerView.Adapter<MyChildCardsAdapter.ViewHolder>  {
Context context;
ArrayList<MyChildInfo> myChildData = new ArrayList<>();

public MyChildCardsAdapter (Context myContext , ArrayList<MyChildInfo> myData){
    this.context = myContext;
    this.myChildData = myData;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_my_child_cards, parent, false);
        return new MyChildCardsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.studentCardLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        MyChildFragment myChildFragment = new MyChildFragment();
        FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, myChildFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
});
    }

    @Override
    public int getItemCount() {
        return myChildData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView childImg;
        TextView childName,rollNo, className,sec;
        RelativeLayout studentCardLayout;

        ViewHolder(View itemView) {
            super(itemView);
            studentCardLayout = itemView.findViewById(R.id.studentView);
            childImg = itemView.findViewById(R.id.childImage);
            childName = itemView.findViewById(R.id.childName);
            rollNo = itemView.findViewById(R.id.rollNo);
            className = itemView.findViewById(R.id.className);
            sec = itemView.findViewById(R.id.secName);
        }


    }
}
