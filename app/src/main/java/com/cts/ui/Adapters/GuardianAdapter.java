package com.cts.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cts.Models.MyChildInfo;
import com.cts.R;

import java.util.ArrayList;

public class GuardianAdapter extends RecyclerView.Adapter<GuardianAdapter.ViewHolder> {
    Context context;
    ArrayList<MyChildInfo> myChildData = new ArrayList<>();

    public GuardianAdapter (Context myContext , ArrayList<MyChildInfo> myData){
        this.context = myContext;
        this.myChildData = myData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_guardians, parent, false);
        return new GuardianAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return myChildData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView guardianName,relation, email,phone;

        ViewHolder(View itemView) {
            super(itemView);
            guardianName = itemView.findViewById(R.id.guardianName);
            relation = itemView.findViewById(R.id.relation);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
        }


    }
}
