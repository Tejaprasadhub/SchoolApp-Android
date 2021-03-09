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

import com.cts.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChildPicsAdapter extends RecyclerView.Adapter<ChildPicsAdapter.ViewHolder> {
    Context context;
    ArrayList<Integer> myChildList = new ArrayList<>();

    public ChildPicsAdapter(Context mContext){
        this.context = mContext;
        myChildList.add(R.mipmap.child_1);
        myChildList.add(R.mipmap.child_2);
    }
    @NonNull
    @Override
    public ChildPicsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_child, parent, false);
        return new ChildPicsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildPicsAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(myChildList.get(position));
    }

    @Override
    public int getItemCount() {
        return myChildList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        RelativeLayout relativeLayout;

        ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.childPic);
            relativeLayout = itemView.findViewById(R.id.childLayout);
        }


    }
}
