package com.example.lets_educate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lets_educate.Fragments.TeacherHistoryFragment;
import com.example.lets_educate.Fragments.TeacherHomeFragment;
import com.example.lets_educate.Fragments.TeacherProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Teacher_Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        getSupportActionBar().setTitle("Teacher Dashboard");

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.student_home);
    }

    TeacherHomeFragment firstFragment = new TeacherHomeFragment();
    TeacherHistoryFragment secondFragment = new TeacherHistoryFragment();
    TeacherProfileFragment thirdFragment = new TeacherProfileFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.teacherhome:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
                return true;

            case R.id.teacherhistory:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                return true;

            case R.id.teacherprofile:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
                return true;
        }
        return false;
    }
}