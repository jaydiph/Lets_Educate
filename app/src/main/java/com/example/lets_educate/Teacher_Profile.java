package com.example.lets_educate;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lets_educate.Adapters.TeacherprofileAdapter;
import com.example.lets_educate.Models.Teacher;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Teacher_Profile extends AppCompatActivity {

    ListView lvAvaialbleContributors;
    FirebaseDatabase mDatabase;
    DatabaseReference mGetReference;
    ArrayList<Teacher> teacherArrayList;
    Teacher teacher;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__profile);

        mDatabase = FirebaseDatabase.getInstance();
        mGetReference = mDatabase.getReference("Teachers");
        lvAvaialbleContributors = findViewById(R.id.retriveddata);
        teacherArrayList = new ArrayList<>();

        user = FirebaseAuth.getInstance().getCurrentUser();

        getData();
    }

    private void getData () {

        mGetReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        teacher = new Teacher(
                                child.child("fname").getValue().toString(),
                                child.child("lname").getValue().toString(),
                                child.child("address").getValue().toString(),
                                child.child("phoneno").getValue().toString(),
                                child.child("intrest").getValue().toString(),
                                child.child("qualification").getValue().toString(),
                                child.child("skillknowledge").getValue().toString(),
                                child.child("subject").getValue().toString());
                    }
                    teacherArrayList.add(teacher);

                    //  Log.v("DS","listsize"+contributorArrayList.size());

                    TeacherprofileAdapter teacherprofileAdapter = new TeacherprofileAdapter(Teacher_Profile.this,
                           teacherArrayList);
                    lvAvaialbleContributors.setAdapter(teacherprofileAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}