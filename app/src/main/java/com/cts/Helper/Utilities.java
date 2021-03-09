package com.cts.Helper;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.cts.Abstracts.ConfirmationAbstract;
import com.cts.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.Inflater;

public final class Utilities {

    public static final String My_login_pref = "MyLoginData";
    public static final String isLogin = "isLogin";
    public static final String userType = "UserType";
    public static final String Parent = "Parent";
    public static final String Teacher = "Teacher";

    public static String dateToStringConvertor(String format , Date date ){
        SimpleDateFormat simpleDate =  new SimpleDateFormat(format);
        return simpleDate.format(date);
    }

    public static Date stringToDateConvertor(String format, String date) throws ParseException {
        SimpleDateFormat simpleDate =  new SimpleDateFormat(format);
        return simpleDate.parse(date);
    }

    public static int getWeekDay(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String dayOfTheWeek = sdf.format(date);
        switch (dayOfTheWeek){
            case "Sunday" : {
               return 0;
            }

            case "Monday" : {
               return 1;
            }

            case "Tuesday":{
                return  2;
            }

            case "Wednesday":{
                return 3;
            }

            case "Thursday":{
                return 4;
            }

            case "Friday":{
                return  5;
            }

            case "Saturday":{
                return 6;
            }

            default: {
                return 0;
            }
        }
    }


    public static void showLogoutPop(Activity activity , final ConfirmationAbstract confirmationAbstract){
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View alertDialoguePopUpLyt = inflater.inflate(R.layout.popup_logout,null);
        final PopupWindow alertPopUpWindow = new PopupWindow(alertDialoguePopUpLyt, RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT,true);
         View popUpWindowLayout = alertPopUpWindow.getContentView();
        Button yesBtn = popUpWindowLayout.findViewById(R.id.yesBtn);
        Button noBtn = popUpWindowLayout.findViewById(R.id.noBtn);
        alertPopUpWindow.showAtLocation(popUpWindowLayout, Gravity.NO_GRAVITY,0,0);
        alertPopUpWindow.update();

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmationAbstract.submitBtn();
                alertPopUpWindow.dismiss();
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertPopUpWindow.dismiss();
            }
        });
    }
}
