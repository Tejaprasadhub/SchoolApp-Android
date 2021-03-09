package com.cts.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cts.R;

import java.util.ArrayList;

public class ChaptersAdapter extends RecyclerView.Adapter<ChaptersAdapter.ViewHolder> {
Context mContext;
ArrayList<Integer> myDatalist = new ArrayList<>();

public ChaptersAdapter(Context context){
    mContext = context;
    for(int i = 0; i < 5; i ++){
        myDatalist.add(i);
    }
}


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chapters, parent, false);
        return new ChaptersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return myDatalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView chapterName,chapterDesc;

        ViewHolder(View itemView) {
            super(itemView);
           chapterName = itemView.findViewById(R.id.chapterName);
           chapterDesc = itemView.findViewById(R.id.chapterDesc);
        }

    }
}
