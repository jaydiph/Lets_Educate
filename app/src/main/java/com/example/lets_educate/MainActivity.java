package com.example.lets_educate;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public TextView textView, fpass;
    public EditText email1, password1 ;
    public RadioButton student,teacher,ngo;
    public RadioGroup radioGroup;
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fpass = (TextView) findViewById(R.id.forgotpassword);
        button = (Button) findViewById(R.id.btnlogin);
        textView = (TextView) findViewById(R.id.txt);
        email1 = (EditText) findViewById(R.id.etemail);
        password1 = (EditText) findViewById(R.id.mypass);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String userId;
        radioGroup = findViewById(R.id.radiogroup);

        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Forgot_Password.class);
                startActivity(i);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {
                String email = email1.getText().toString().trim();
                String password = password1.getText().toString().trim();
                if (email.isEmpty()) {
                    email1.setError("Email is empty");
                    email1.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    email1.setError("Enter the valid email");
                    email1.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    password1.setError("Password is empty");
                    password1.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    password1.setError("Length of password is more than 6");
                    password1.requestFocus();
                    return;
                }

                user = mAuth.getCurrentUser();
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
//                    if(user.isEmailVerified()) {
                    if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Your Login Suceesfully To Let's Educate", Toast.LENGTH_SHORT).show();
                            if (radioGroup.getCheckedRadioButtonId() == R.id.studentradio) {
                                Intent i = new Intent(getApplicationContext(), Student_register.class);
                                startActivity(i);
                            }
                            if (radioGroup.getCheckedRadioButtonId() == R.id.teacherradio) {
                                Intent i = new Intent(getApplicationContext(),Teacher_Home.class);
                                startActivity(i);
                            }
                            if (radioGroup.getCheckedRadioButtonId() == R.id.ngoradio) {
                                Intent i = new Intent(getApplicationContext(), NGO_Profile.class);
                                startActivity(i);
                            }
                        if (radioGroup.getCheckedRadioButtonId() == R.id.instituteradio) {
                            Intent i = new Intent(getApplicationContext(), ContributorActivity.class);
                            startActivity(i);
                        }

                        }
                    else{

                        Toast.makeText(getApplicationContext(),
                                "Please Check Your login Credentials",
                                Toast.LENGTH_SHORT).show();
                        }

//                    }
//                    else {
//
//                        Toast.makeText(getApplicationContext(),
//                                "Email is Not Verifyed ! Verify Your Email..",
//                                Toast.LENGTH_SHORT).show();
//                    }

                });
            }
        });



        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Registration.class);
            startActivity(intent);

        });
    }
}