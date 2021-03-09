package com.cts.ui.Adapters;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cts.Models.NoticeBoard;
import com.cts.Models.TeachersHomeWork;
import com.cts.R;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class TeacherHomeWorkAdapter extends RecyclerView.Adapter<TeacherHomeWorkAdapter.ViewHolder>{
    Context context;
    ArrayList<TeachersHomeWork> myHomeWorkData = new ArrayList<>();
    // Progress Dialog
    private ProgressDialog pDialog;
    public static final int progress_bar_type = 0;

    public TeacherHomeWorkAdapter (Context myContext , ArrayList<TeachersHomeWork> myData){
        this.context = myContext;
        this.myHomeWorkData = myData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_teacher_homework, parent, false);
        return new TeacherHomeWorkAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
TeachersHomeWork obj = myHomeWorkData.get(position);
holder.homewokTitle.setText(obj.chapterName);
holder.className.setText(obj.className);
holder.secName.setText(obj.secName);
holder.subject.setText(obj.subjectName);
holder.assigndate.setText(obj.assignDate);
holder.submitdate.setText(obj.submissionDate);
holder.downloadBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        new DownloadFileFromURL().execute(myHomeWorkData.get(position).uploadFile);
    }
});
    }

    @Override
    public int getItemCount() {
        return myHomeWorkData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton downloadBtn,deleteBtn;
        TextView homewokTitle,className,secName,subject,assigndate,submitdate;

        ViewHolder(View itemView) {
            super(itemView);
            downloadBtn = itemView.findViewById(R.id.downloadBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            homewokTitle = itemView.findViewById(R.id.hm_title);
            className = itemView.findViewById(R.id.className);
            secName = itemView.findViewById(R.id.section);
            subject =itemView.findViewById(R.id.subject);
            assigndate = itemView.findViewById(R.id.assigndate);
            submitdate = itemView.findViewById(R.id.submissiondate);
        }


    }


    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type: // we set this to 0
                pDialog = new ProgressDialog(context);
                pDialog.setMessage("Downloading file. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setCancelable(true);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }

    class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Bar Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * Downloading file in background thread
         * */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                URL url = new URL(f_url[0]);
                URLConnection connection = url.openConnection();
                connection.connect();

                // this will be useful so that you can show a tipical 0-100%
                // progress bar
                int lenghtOfFile = connection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(),
                        8192);

                // Output stream
                OutputStream output = new FileOutputStream(Environment
                        .getExternalStorageDirectory().toString()
                        + "/2011.kml");

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        /**
         * Updating progress bar
         * */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
        }

    }

}
