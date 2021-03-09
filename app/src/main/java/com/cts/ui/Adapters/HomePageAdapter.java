package com.cts.ui.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.cts.Models.FeesCategory;
import com.cts.R;
import java.util.ArrayList;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ViewHolder> {
    Context context;
    ArrayList<FeesCategory> displayList = new ArrayList();
onItemClickListener itemClickListener ;
    public  HomePageAdapter(Context mContext, ArrayList<FeesCategory> myList, onItemClickListener listener ){
        context = mContext;
        displayList = myList;
        itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_home_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(displayList.get(position).name);
        if(displayList.get(position).iconName != 0){
            holder.imageView.setImageResource(displayList.get(position).iconName);
        }
       else if(displayList.get(position).imageUrl != ""){
           Glide.with(context).load(displayList.get(position).imageUrl).into(holder.imageView);

        }

       if(displayList.get(position).isSelected == true){
           holder.isSelected.setVisibility(View.VISIBLE);
       }
       else{
           holder.isSelected.setVisibility(View.GONE);
       }

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(view,position);
//
            }
        });
    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView,isSelected;
        RelativeLayout relativeLayout;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.icon);
            isSelected = itemView.findViewById(R.id.isSelect);
            relativeLayout = itemView.findViewById(R.id.catg);
        }


    }

    public interface  onItemClickListener {
     void onItemClick(View view , Integer position);
    }

    public void UpdateList(ArrayList<FeesCategory> myList){
        displayList = myList;
        notifyDataSetChanged();
    }


}
