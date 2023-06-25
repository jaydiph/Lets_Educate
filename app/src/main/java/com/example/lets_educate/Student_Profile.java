package com.example.lets_educate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lets_educate.Adapters.StudentProfileAdapter;
import com.example.lets_educate.Models.Student;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Student_Profile extends AppCompatActivity {

    ListView lvAvaialbleContributors;
    FirebaseDatabase mDatabase;
    DatabaseReference mGetReference;
    ArrayList<Student> studentArrayList;
    Student student;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__profile);


        mDatabase = FirebaseDatabase.getInstance();
        mGetReference = mDatabase.getReference("Students");
        lvAvaialbleContributors = findViewById(R.id.retriveddata);
        studentArrayList = new ArrayList<>();

        user = FirebaseAuth.getInstance().getCurrentUser();

        getData();

        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.student_profile);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.student_home:
                        startActivity(new Intent(getApplicationContext(), Student_Home.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.becometeacher:
                        startActivity(new Intent(getApplicationContext(), Become_Teacher.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.student_history:
                        startActivity(new Intent(getApplicationContext(), Student_History.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.student_profile:

                        return true;


                }

                return false;
            }
        });


    }


    private void getData() {

        mGetReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        student = new Student(
                                child.child("fname").getValue().toString(),
                                child.child("lname").getValue().toString(),
                                child.child("email").getValue().toString(),
                                child.child("address").getValue().toString(),
                                child.child("phoneno").getValue().toString(),
                                child.child("school_college").getValue().toString(),
                                child.child("qualification").getValue().toString(),
                                child.child("fav_subject").getValue().toString(),
                                child.child("percentage").getValue().toString());
                    }
                    studentArrayList.add(student);

                    //  Log.v("DS","listsize"+contributorArrayList.size());

                    StudentProfileAdapter studentProfileAdapter = new StudentProfileAdapter(Student_Profile.this,
                            studentArrayList);
                    lvAvaialbleContributors.setAdapter(studentProfileAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
        switch (id) {
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