package com.example.lets_educate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lets_educate.Models.Teacher;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register_Teacher extends AppCompatActivity {

    private Button submit;
    private EditText firstname,lastname,phoneno,address,qualification,intrest,skillandknowledge,subject;
     FirebaseDatabase db;
     DatabaseReference root ;
     FirebaseUser user;
     Teacher teacher;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__teacher);

        submit = findViewById(R.id.submit11);
        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        phoneno = findViewById(R.id.phone_no);
        address = findViewById(R.id.address);
        qualification = findViewById(R.id.qualification);
        intrest = findViewById(R.id.intrest);
        skillandknowledge = findViewById(R.id.skill_knowledge);
        subject = findViewById(R.id.subject);


        teacher = new Teacher();





        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = FirebaseDatabase.getInstance();
                root = db.getReference().child("Teachers");

              user = FirebaseAuth.getInstance().getCurrentUser();


               String f_firstname = firstname.getText().toString();
                String f_lastname = lastname.getText().toString();
                String f_phoneno = phoneno.getText().toString();
                String f_address = address.getText().toString();
                String f_qualification = qualification.getText().toString();
                String f_intrest = intrest.getText().toString();
                String f_skillandknowledge = skillandknowledge.getText().toString();
                String f_subject = subject.getText().toString();

                addDatatoFirebase(f_firstname,f_lastname,f_phoneno,f_address,f_qualification,f_intrest,f_skillandknowledge,f_subject);




            }

            private void addDatatoFirebase(String f_firstname, String f_lastname, String f_phoneno, String f_address, String f_qualification, String f_intrest, String f_skillandknowledge, String f_subject) {

                teacher.setFname(f_firstname);
                teacher.setLname(f_lastname);
                teacher.setPhoneno(f_phoneno);
                teacher.setAddress(f_address);
                teacher.setQualification(f_qualification);
                teacher.setIntrest(f_intrest);
                teacher.setSkillknowledge(f_skillandknowledge);
                teacher.setSubject(f_subject);


                root.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        root.child(user.getUid()).setValue(teacher);
                        Toast.makeText(Register_Teacher.this, "Data Inserted Sucessfully...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });



    }


}