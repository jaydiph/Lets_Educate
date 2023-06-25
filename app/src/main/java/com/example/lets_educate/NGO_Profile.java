package com.example.lets_educate;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lets_educate.Adapters.NgoProfileAdapter;
import com.example.lets_educate.Models.Ngo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NGO_Profile extends AppCompatActivity {

    ListView lvAvaialbleContributors;
    FirebaseDatabase mDatabase;
    DatabaseReference mGetReference;
    ArrayList<Ngo> ngoArrayList;
    Ngo ngo;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_g_o__profile);


        mDatabase = FirebaseDatabase.getInstance();
        mGetReference = mDatabase.getReference("NGOs");
        lvAvaialbleContributors = findViewById(R.id.retriveddata);
        ngoArrayList = new ArrayList<>();

        user = FirebaseAuth.getInstance().getCurrentUser();

        getData();

    }
    private void getData () {

        mGetReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        ngo = new Ngo(
                                child.child("name").getValue().toString(),
                                child.child("email").getValue().toString(),
                                child.child("phoneno").getValue().toString(),
                                child.child("address").getValue().toString());
                    }
                    ngoArrayList.add(ngo);

                    //  Log.v("DS","listsize"+contributorArrayList.size());

                    NgoProfileAdapter ngoProfileAdapter = new NgoProfileAdapter(NGO_Profile.this,
                            ngoArrayList);
                    lvAvaialbleContributors.setAdapter(ngoProfileAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}