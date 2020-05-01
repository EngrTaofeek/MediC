package iemergency.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private  long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");


        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);

        Bundle intent = getIntent().getExtras();

        getSupportActionBar().setTitle("Home");
        HomeFragment fragment0 = new HomeFragment();
        FragmentTransaction ft0 = getSupportFragmentManager().beginTransaction();
        ft0.replace(R.id.content,fragment0,"");
        ft0.commit();



    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()){

                        case R.id.nav_home:
                            getSupportActionBar().setTitle("Home");
                            HomeFragment fragment0 = new HomeFragment();
                            FragmentTransaction ft0 = getSupportFragmentManager().beginTransaction();
                            ft0.replace(R.id.content,fragment0,"");
                            ft0.commit();
                            return true;
                        case R.id.nav_info:
                            getSupportActionBar().setTitle("About the Virus");
                            InfoFragment fragment1 = new InfoFragment();
                            FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                            ft1.replace(R.id.content,fragment1,"");
                            ft1.commit();
                            return true;
                        case R.id.nav_map:
                            getSupportActionBar().setTitle("Updates");
                            NewsFragment fragment2 = new NewsFragment();
                            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                            ft2.replace(R.id.content,fragment2,"");
                            ft2.commit();
                            return true;
                    }

                    return false;
                }
            };

    @Override
    public void onBackPressed() {
        if (backPressedTime +2000 > System.currentTimeMillis()){
            super.onBackPressed();
            finish();
        }else{
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }


}
