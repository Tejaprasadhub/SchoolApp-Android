package com.cts.ui.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.cts.Abstracts.ConfirmationAbstract;
import com.cts.Helper.Utilities;
import com.cts.R;


public class MyStuffFragment extends Fragment implements View.OnClickListener {
ImageButton backBtn;
LinearLayout viewProfileLayout,editProfileLayout,ChangePasswordLayout,SettingsLayout,ContactUsLayout,Logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_my_stuff, container, false);
        init(root);

        return root;
    }


    private void init(View root) {
        backBtn = root.findViewById(R.id.backBtn);
viewProfileLayout = root.findViewById(R.id.viewProfileLayout);
editProfileLayout = root.findViewById(R.id.editProfileLayout);
ChangePasswordLayout = root.findViewById(R.id.changePassLayout);
SettingsLayout = root.findViewById(R.id.settingsLayout);
ContactUsLayout = root.findViewById(R.id.contactLayout);
Logout = root.findViewById(R.id.signoutLayout);
       backBtn.setOnClickListener(this);
       viewProfileLayout.setOnClickListener(this);
       editProfileLayout.setOnClickListener(this);
       ChangePasswordLayout.setOnClickListener(this);
       ContactUsLayout.setOnClickListener(this);
       SettingsLayout.setOnClickListener(this);
       Logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn : {
                getFragmentManager().popBackStack();
            }
            break;
            case R.id.viewProfileLayout : {
                MyProfileFragment profileFragment = new MyProfileFragment();
                Bundle args = new Bundle();
                args.putString("caller", "view");
                profileFragment.setArguments(args);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, profileFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
            break;
            case R.id.editProfileLayout:{
                MyProfileFragment profileFragment = new MyProfileFragment();
                Bundle args = new Bundle();
                args.putString("caller", "edit");
                profileFragment.setArguments(args);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, profileFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
            break;
            case R.id.changePassLayout : {
                ChangePasswordFragment changePasswordFragment = new ChangePasswordFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, changePasswordFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
            break;
            case R.id.contactLayout : {
                ContactUsFragment contactUsFragment = new ContactUsFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, contactUsFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
            break;
            case R.id.settingsLayout : {
                SettingsFragment settingsLayout = new SettingsFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, settingsLayout);
                transaction.addToBackStack(null);
                transaction.commit();
            }
            break;
            case R.id.signoutLayout:{
                Utilities.showLogoutPop(getActivity(),new ConfirmationAbstract(){
                    @Override
                    public void submitBtn() {
                        super.submitBtn();
                        Log.e("message" , "i am called");
                        SharedPreferences sharedPreferences = getActivity().getApplicationContext().getSharedPreferences(Utilities.My_login_pref, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.apply();
                        getActivity().finish();
                    }
                });
            }
            break;
            default:{

            }
        }
    }
}