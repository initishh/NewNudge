package com.example.nudgerewriten.activities;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.design.widget.BottomNavigationView;
import android.view.Window;
import android.view.WindowManager;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.fragments.CropAndMarketFragment;
import com.example.nudgerewriten.fragments.FarmerListFragment;
import com.example.nudgerewriten.fragments.HomeFragment;
import com.example.nudgerewriten.fragments.ProfileFragment;
import com.example.nudgerewriten.fragments.ServicesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView botNav = findViewById(R.id.bottom_navigation);
        botNav.setOnNavigationItemSelectedListener(navlistener);

        // Setting the status bar color to PrimaryDark for all fragments

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectedFragment= null;
                    switch (menuItem.getItemId())
                    {
                        case R.id.home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.c_m:
                            selectedFragment = new CropAndMarketFragment();
                            break;
                        case R.id.farmer:
                            selectedFragment = new FarmerListFragment();
                            break;
                        case R.id.profile:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.service:
                            selectedFragment = new ServicesFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }

            };
}
