package com.cts.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cts.Models.DropDownData;
import com.cts.R;



import java.util.ArrayList;
import java.util.List;

public class DropDownCustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<DropDownData> myData = new ArrayList<>() ;

    public  DropDownCustomAdapter(Context myContext,ArrayList<DropDownData> dropdownData){
mContext = myContext;
myData = dropdownData;
    }

    @Override
    public int getCount() {
        return myData.size();
    }

    @Override
    public Object getItem(int i) {
        return myData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.list_item_dropdown, null);
       View seperator = view.findViewById(R.id.seperator);
        TextView names = (TextView) view.findViewById(R.id.option);
        names.setText(myData.get(i).name);
        if(i == myData.size() -1){
            seperator.setVisibility(View.GONE);
        }
        else{
            seperator.setVisibility(View.VISIBLE);
        }

        return view;
    }

}
