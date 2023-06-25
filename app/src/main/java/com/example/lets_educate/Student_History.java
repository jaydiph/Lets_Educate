package com.example.lets_educate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Student_History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__history);



        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.student_history);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.student_home :
                        startActivity(new Intent(getApplicationContext(), Student_Home.class));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.becometeacher :
                        startActivity(new Intent(getApplicationContext(),Become_Teacher.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.student_history :

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