package com.example.potholedectection.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.potholedectection.Adapter.ViewPager;
import com.example.potholedectection.Fragment.DepthPageTransformer;
import com.example.potholedectection.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewpager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewPager myadapter = new ViewPager(this);
        viewPager2.setAdapter(myadapter);

        viewPager2.setPageTransformer(new DepthPageTransformer());//hiệu ứng chuyển màn

        //click vào item bottom nav
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.bottom_Home) {

                    viewPager2.setCurrentItem(0);  //position trong adapter ViewPager

                } else if (id == R.id.bottom_Dashboard) {

                    viewPager2.setCurrentItem(1);

                } else if (id == R.id.bottom_User) {

                    viewPager2.setCurrentItem(2);

                } else if (id == R.id.bottom_Setting) {

                    viewPager2.setCurrentItem(3);
                }
                return true;
            }
        });

        //vuốt màn hình
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position) {

                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_Home).setChecked(true);
                        break;

                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_Dashboard).setChecked(true);
                        break;

                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_User).setChecked(true);
                        break;

                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_Setting).setChecked(true);
                        break;
                }
            }
        });
    }

    private void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String language = prefs.getString("Language", "");
        if (!language.isEmpty()) {
            Locale locale = new Locale(language);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }
    }

}

