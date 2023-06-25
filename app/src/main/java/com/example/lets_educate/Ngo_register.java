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

import com.example.lets_educate.Models.Ngo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Ngo_register extends AppCompatActivity {

    EditText name,email,address,phoneno;
    Button submit;
    CheckBox terms;
    TextView termss ;
    FirebaseDatabase db;
    DatabaseReference root ;
    FirebaseUser user;
    Ngo ngo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_g_o__register);

        name = findViewById(R.id.namengo);
        email = findViewById(R.id.emailngo);
        address = findViewById(R.id.addressngo);
        phoneno = findViewById(R.id.phonenongo);
        terms = (CheckBox) findViewById(R.id.checkBox1);
        termss = (TextView) findViewById(R.id.tc);
        submit = findViewById(R.id.submitngo);

        ngo = new Ngo();

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {




                db = FirebaseDatabase.getInstance();
                root = db.getReference().child("NGOs");

                user = FirebaseAuth.getInstance().getCurrentUser();

                String n_name = name.getText().toString();
                String n_email = email.getText().toString();
                String n_address = address.getText().toString();
                String n_phoneno = phoneno.getText().toString();

                addDatatoFirebase(n_name,n_email,n_address,n_phoneno);

                if(n_name.isEmpty())
                {
                    name.setError("Email is empty");
                    name.requestFocus();
                    return;
                }
                if(n_email.isEmpty())
                {
                    email.setError("Email is empty");
                    email.requestFocus();
                    return;
                }
                if(n_address.isEmpty())
                {
                    address.setError("Email is empty");
                    address.requestFocus();
                    return;
                }
                if(n_phoneno.isEmpty())
                {
                    phoneno.setError("Email is empty");
                    phoneno.requestFocus();
                    return;
                }
                Intent i = new Intent(getApplicationContext(),NGO_Profile.class);
                startActivity(i);
            }

            private void addDatatoFirebase(String n_name, String n_email, String n_address, String n_phoneno) {

                ngo.setName(n_name);
                ngo.setEmail(n_email);
                ngo.setAddress(n_address);
                ngo.setPhoneno(n_phoneno);

                root.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        root.child(user.getUid()).setValue(ngo);
                        Toast.makeText(Ngo_register.this, "Data Inserted Sucessfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        Toast.makeText(Ngo_register.this, "Error..", Toast.LENGTH_SHORT).show();
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