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

import com.cts.Models.FeesCategory;
import com.cts.Models.FeesCategoryData;
import com.cts.R;

import java.util.ArrayList;

public class FeesDataAdapter  extends RecyclerView.Adapter<FeesDataAdapter.ViewHolder> {
    ArrayList<FeesCategoryData> myDataList = new ArrayList<>();
    Context mContext ;

    public  FeesDataAdapter(Context myContext, ArrayList<FeesCategoryData> myData){
        this.mContext = myContext;
        this.myDataList = myData;
    }

    @NonNull
    @Override
    public FeesDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_fees_catg, parent, false);
        return new FeesDataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeesDataAdapter.ViewHolder holder, int position) {
   FeesCategoryData obj = myDataList.get(position);
   holder.studentName.setText(obj.name);
   if(obj.status.equals("PEN")){
       holder.pendingStatus.setVisibility(View.VISIBLE);
       holder.successStatus.setVisibility(View.GONE);
   }
   else{
       holder.pendingStatus.setVisibility(View.GONE);
       holder.successStatus.setVisibility(View.VISIBLE);
   }

   holder.className.setText(obj.className);
   holder.rollNo.setText(obj.rollNo);
   holder.totalAmt.setText(obj.totalAmt);
       if(obj.padiDate != ""){
           holder.paidDate.setText(obj.padiDate);
       }
       else{
           holder.paidDate.setText("-");
       }
        if(obj.paidAmt != ""){
            holder.paidAmt.setText(obj.paidAmt);
        }
        else{
            holder.paidAmt.setText("-");
        }
        if(obj.dueAmt != ""){
            holder.dueAmt.setText(obj.dueAmt);
        }
        else{
            holder.dueAmt.setText("-");
        }

//           holder.paidAmt.setText(obj.paidAmt);
//           holder.dueAmt.setText(obj.dueAmt);
    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView studentName,pendingStatus,successStatus,className,rollNo,totalAmt,paidDate,paidAmt,dueAmt;

        ViewHolder(View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.childName);
           pendingStatus = itemView.findViewById(R.id.pendingCard);
           successStatus = itemView.findViewById(R.id.successCard);
           className = itemView.findViewById(R.id.className);
           rollNo = itemView.findViewById(R.id.rollNo);
           totalAmt = itemView.findViewById(R.id.totalAmt);
           paidDate  = itemView.findViewById(R.id.paiddate);
           paidAmt = itemView.findViewById(R.id.paidAmt);
           dueAmt = itemView.findViewById(R.id.dueAmt);
        }


    }

    public void UpdateList(ArrayList<FeesCategoryData> myList){
        myDataList = myList;
        notifyDataSetChanged();
    }
}
