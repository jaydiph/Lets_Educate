package com.example.lets_educate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lets_educate.Fragments.Live_Fragment;
import com.example.lets_educate.Fragments.Upcomming_Fragment;
import com.example.lets_educate.Tabs.Tab_Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class Student_Home extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        tabLayout = findViewById(R.id.tabLayout1);
        viewPager = findViewById(R.id.viewpager1);

        tabLayout.setupWithViewPager(viewPager);

        Tab_Adapter tab_adapter = new Tab_Adapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        tab_adapter.addFragment(new Upcomming_Fragment(), "UPCOMMING");
        tab_adapter.addFragment(new Live_Fragment(), "LIVE");
        viewPager.setAdapter(tab_adapter);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.student_home);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.student_home :
                        return true;

                    case R.id.becometeacher :
                        startActivity(new Intent(getApplicationContext(), Become_Teacher.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.student_history :
                        startActivity(new Intent(getApplicationContext(),Student_History.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.student_profile :
                        startActivity(new Intent(getApplicationContext(), Student_Profile.class));
                        overridePendingTransition(0,0);
                        return true;


                }

                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.help:
                startActivity(new Intent(getApplicationContext(), Help.class));
                return true;
            case R.id.aboutus:
                startActivity(new Intent(getApplicationContext(), About_Us.class));
                return true;
            case R.id.contactus:
                startActivity(new Intent(getApplicationContext(), Contact_Us.class));
                return true;
            case R.id.termscondition:
                startActivity(new Intent(getApplicationContext(), Terms_and_Condition.class));
                return true;
            case R.id.feedback:
                startActivity(new Intent(getApplicationContext(), Feedback.class));
                return true;
            case R.id.logout:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }











}