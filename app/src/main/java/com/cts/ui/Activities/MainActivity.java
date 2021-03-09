package com.cts.ui.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.cts.R;
import com.cts.ui.Fragments.AboutUsFragment;
import com.cts.ui.Fragments.HomeFragment;
import com.cts.ui.Fragments.MyStuffFragment;
import com.cts.ui.Fragments.NoticeBoardFragment;
import com.cts.ui.Fragments.ReferFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
HomeFragment homeFragment = new HomeFragment();
MyStuffFragment myStuffFragment = new MyStuffFragment();
AboutUsFragment aboutUsFragment = new AboutUsFragment();
ReferFragment referFragment = new ReferFragment();
NoticeBoardFragment noticeBoardFragment = new NoticeBoardFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_noticeboard:
                        makeCurrentFragment(noticeBoardFragment,R.id.navigation_noticeboard);
                        break;
                    case R.id.navigation_refer:
                        makeCurrentFragment(referFragment,R.id.navigation_refer);
                        break;
                    case R.id.navigation_home:
                        makeCurrentFragment(homeFragment,R.id.navigation_home);
                        break;
                    case R.id.navigation_about:
                        makeCurrentFragment(aboutUsFragment,R.id.navigation_about);
                        break;
                    case R.id.navigation_mystuff:
                        makeCurrentFragment(myStuffFragment,R.id.navigation_mystuff);
                        break;
                    default:
                       makeCurrentFragment(homeFragment,R.id.navigation_home);
                        break;
                }
                return false;
            }
        });
        makeCurrentFragment(homeFragment,R.id.navigation_home);

    }

    public void makeCurrentFragment(Fragment fragment, Integer itemId){

        for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
            MenuItem menuItem = bottomNavigationView.getMenu().getItem(i);
            boolean isChecked = menuItem.getItemId() == itemId;
            menuItem.setChecked(isChecked);
            if(isChecked == true){
                break;
            }
        }
        FragmentManager fm = getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment);
        transaction.commit();

    }

}