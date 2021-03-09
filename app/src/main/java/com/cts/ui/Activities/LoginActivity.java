package com.cts.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;


import com.cts.Helper.Utilities;
import com.cts.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
Button loginBtn,forgotBtn;
EditText email,password,schlId;
TextView version;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
        initListeners();
    }

    private void initListeners() {
        loginBtn.setOnClickListener(this);
        forgotBtn.setOnClickListener(this);
    }

    private void initComponents() {
        loginBtn = findViewById(R.id.login);
        forgotBtn = findViewById(R.id.forgotpass);
        email = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        version = findViewById(R.id.version);
        schlId = findViewById(R.id.schlcode);
        sharedPreferences = getApplicationContext().getSharedPreferences(Utilities.My_login_pref, MODE_PRIVATE);


    }



    @Override
    public void onClick(View view) {
        if(view == loginBtn){
            if(!(email.getText().toString().matches("")) && !(password.getText().toString().matches(""))){
                editor = sharedPreferences.edit();
                if(email.getText().toString().equals("Usharani") && password.getText().toString().equals("dipusha9963")){
                    editor.putString(Utilities.userType , Utilities.Parent);
                    editor.putBoolean(Utilities.isLogin , true);
                }
                else if(email.getText().toString().equals("Dheeraj")  && password.getText().toString().equals("dipusha9963") ){
                    editor.putString(Utilities.userType , Utilities.Teacher);
                    editor.putBoolean(Utilities.isLogin , true);
                }
                editor.commit();
                editor.apply();
                email.setText("");
                password.setText("");
                Intent mainActivityIntent = new Intent(this,MainActivity.class);
                startActivity(mainActivityIntent);

            }
            else{
             Log.e("message" , "");
            }

        }
        else if(view == forgotBtn){
            Intent forgotActvity = new Intent(this, ForgotPasswordActivity.class);
            startActivity(forgotActvity);
        }
    }
}