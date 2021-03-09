package com.cts.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.cts.Helper.Utilities;
import com.cts.R;
import com.cts.ui.Activities.LoginActivity;

public class SplashScreen extends AppCompatActivity {
    SharedPreferences editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        editor = getSharedPreferences(Utilities.My_login_pref, MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("editor value" , String.valueOf(editor.getBoolean(Utilities.isLogin,false)));
                if(editor.getBoolean(Utilities.isLogin,false) == true){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },500);
    }
}