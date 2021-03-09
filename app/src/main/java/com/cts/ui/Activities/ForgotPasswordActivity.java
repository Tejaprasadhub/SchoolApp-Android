package com.cts.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.cts.R;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {
Button backToLogin,continueBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initComponents();
        initListeners();
    }

    private void initListeners() {
        backToLogin.setOnClickListener(this);
        continueBtn.setOnClickListener(this);
    }

    private void initComponents() {
        backToLogin = findViewById(R.id.back);
        continueBtn = findViewById(R.id.next);
    }

    @Override
    public void onClick(View view) {
        if(view == backToLogin){
            finish();
        }
        else if(view == continueBtn){
Intent changePassIntent = new Intent(this,ChangePasswordActivity.class);
startActivity(changePassIntent);
        }
    }
}