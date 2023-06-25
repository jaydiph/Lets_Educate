package com.example.lets_educate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

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