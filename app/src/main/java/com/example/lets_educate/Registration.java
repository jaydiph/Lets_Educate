package com.example.lets_educate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    public Button button;
    public EditText email1, password1 , confirmpassword;
    public CheckBox terms;
    public TextView termss ;
    private FirebaseAuth mAuth;
    public RadioButton student,teacher,ngo;
    public RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        termss = (TextView) findViewById(R.id.tc);
        button = (Button) findViewById(R.id.button11);
        email1 = (EditText) findViewById(R.id.Email);
        password1 = (EditText) findViewById(R.id.TextPassword);
        terms = (CheckBox) findViewById(R.id.checkBox);
        confirmpassword = (EditText) findViewById(R.id.passwordconfirm);

        mAuth=FirebaseAuth.getInstance();



        termss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Terms_and_Condition.class);
                startActivity(i);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {

                String email = email1.getText().toString().trim();
                String password= password1.getText().toString().trim();
                String cpass = confirmpassword.getText().toString().trim();
                if(email.isEmpty())
                {
                    email1.setError("Email is empty");
                    email1.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    email1.setError("Enter the valid email address");
                    email1.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    password1.setError("Enter the password");
                    password1.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    password1.setError("Length of the password should be more than 6");
                    password1.requestFocus();
                    return;
                }
                if(!password.equals(cpass)){
                    confirmpassword.setError("Enter Same Password as above");
                    confirmpassword.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            FirebaseUser user = mAuth.getCurrentUser();
                            user.sendEmailVerification()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(Registration.this,"You are successfully Registered. Check Your Email For Verification", Toast.LENGTH_LONG).show();
                                                email1.setText("");
                                                password1.setText("");
                                                confirmpassword.setText("");
                                                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                                startActivity(i);
                                            }else
                                            {
                                                Toast.makeText(Registration.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });

                        }
                        else
                        {
                            Toast.makeText(Registration.this,"You are not Registered! Try again",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

    }


}