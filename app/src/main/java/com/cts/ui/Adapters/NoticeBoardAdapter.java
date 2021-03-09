package com.cts.ui.Adapters;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cts.Models.MyChildInfo;
import com.cts.Models.NoticeBoard;
import com.cts.R;

import java.util.ArrayList;

import uk.co.deanwild.flowtextview.FlowTextView;

public class NoticeBoardAdapter extends RecyclerView.Adapter<NoticeBoardAdapter.ViewHolder> {

    Context context;
    ArrayList<NoticeBoard> myNoticeData = new ArrayList<>();

    public NoticeBoardAdapter (Context myContext , ArrayList<NoticeBoard> myData){
        this.context = myContext;
        this.myNoticeData = myData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_notice_board, parent, false);
        return new NoticeBoardAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoticeBoard obj = myNoticeData.get(position);
        holder.noticeHeading.setText(obj.noticeHeading);
        holder.noticeDate.setText(obj.noticeDate);
        Spanned html = Html.fromHtml("<html>\n" +
                "\t<p style=\"fontSize:13px;fontFamily:rubik-regular\">" + obj.noticeDesc + "</p>\n" +
                "</html>");
        holder.noticeDesc.setText(html);
    }

    @Override
    public int getItemCount() {
        return myNoticeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView noticeImg;
        TextView noticeHeading,noticeDate;
        FlowTextView noticeDesc;

        ViewHolder(View itemView) {
            super(itemView);
            noticeImg = itemView.findViewById(R.id.notice_image);
            noticeHeading = itemView.findViewById(R.id.noticeHeading);
            noticeDate = itemView.findViewById(R.id.noticeDate);
            noticeDesc = itemView.findViewById(R.id.notice_desc);
        }


    }
}
