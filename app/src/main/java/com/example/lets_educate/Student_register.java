package com.example.lets_educate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lets_educate.Models.Student;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Student_register extends AppCompatActivity {


    EditText fname,lname,email,phoneno,school_college,address,qualification,fav_subject,percentage;
    Button submit;
    CheckBox terms;
    TextView termss ;
    FirebaseDatabase db;
    DatabaseReference root ;
    FirebaseUser user;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__register);
        terms = (CheckBox) findViewById(R.id.checkBox1);
        termss = (TextView) findViewById(R.id.tc);
        fname = findViewById(R.id.firstname);
        lname = findViewById(R.id.lastname);
        email = findViewById(R.id.emailstudent);
        phoneno = findViewById(R.id.phonestudent);
        school_college= findViewById(R.id.your_school_college);
        qualification = findViewById(R.id.qualificationstudent);
        address = findViewById(R.id.addressstudent);
        fav_subject = findViewById(R.id.favsubject);
        percentage = findViewById(R.id.previousyearpercentage);
        submit = findViewById(R.id.submitstudent);


        student = new Student();



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = FirebaseDatabase.getInstance();
                root = db.getReference().child("Students");

                user = FirebaseAuth.getInstance().getCurrentUser();

                String s_fname = fname.getText().toString();
                String s_lname = lname.getText().toString();
                String s_email = email.getText().toString();
                String s_phoneno = phoneno.getText().toString();
                String s_school_college = school_college.getText().toString();
                String s_address = address.getText().toString();
                String s_qualification = qualification.getText().toString();
                String s_fav_subject = fav_subject.getText().toString();
                String s_percentage = percentage.getText().toString();


                addDatatoFirebase(s_fname,s_lname,s_email,s_phoneno,s_school_college,s_address,s_qualification,s_fav_subject,s_percentage);


            }

            private void addDatatoFirebase(String s_fname, String s_lname, String s_email, String s_phoneno, String s_school_college, String s_address, String s_qualification, String s_fav_subject, String s_percentage) {


                student.setFname(s_fname);
                student.setLname(s_lname);
                student.setEmail(s_email);
                student.setPhoneno(s_phoneno);
                student.setSchool_college(s_school_college);
                student.setAddress(s_address);
                student.setQualification(s_qualification);
                student.setFav_subject(s_fav_subject);
                student.setPercentage(s_percentage);


                root.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        root.child(user.getUid()).setValue(student);

                        Toast.makeText(Student_register.this, "Data Inserted Sucessfully...", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(),Student_Home.class);
                        startActivity(i);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        Toast.makeText(Student_register.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });



        termss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Terms_and_Condition.class);
                startActivity(i);
            }
        });


    }
}