package com.example.lets_educate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Contact_Us extends AppCompatActivity {

    EditText etTo, etSubject,etMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us);


        etTo = findViewById(R.id.ed_to);
        etSubject = findViewById(R.id.ed_subject);
        etMessage = findViewById(R.id.ed_message);

        btnSend = findViewById(R.id.bt_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto"+etTo.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
                startActivity(intent);
            }
        });


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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