package com.example.lets_educate;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lets_educate.Adapters.contributionListAdapter;
import com.example.lets_educate.Models.Contributor;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NGOHomeActivity extends AppCompatActivity {

    ListView lvAvaialbleContributors;
    FirebaseDatabase mDatabase;
    DatabaseReference mGetReference;
    ArrayList<Contributor> contributorArrayList;
    Contributor contributor;

    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngohome);


        mDatabase = FirebaseDatabase.getInstance();
        mGetReference = mDatabase.getReference("Contributors");
        lvAvaialbleContributors = findViewById(R.id.lvAvaialbleContributors);
        contributorArrayList = new ArrayList<>();

        user = FirebaseAuth.getInstance().getCurrentUser();


        getData();
    }

        private void getData () {

            mGetReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            for (DataSnapshot childd : child.getChildren()) {
                                Log.v("DS", "" + child.child("instituteName").getValue().toString());
                                contributor = new Contributor(child.child("instituteName").getValue().toString(),
                                        child.child("instituteAddress").getValue().toString(),
                                        child.child("sittingCapacity").getValue().toString(),
                                        child.child("numberofComputers").getValue().toString(),
                                        child.child("laborclass").getValue().toString(),
                                        child.child("projector").getValue().toString(),
                                        child.child("board").getValue().toString());
                            }
                            contributorArrayList.add(contributor);
                        }
                        //  Log.v("DS","listsize"+contributorArrayList.size());

                        contributionListAdapter contributionListAdapter = new contributionListAdapter(NGOHomeActivity.this,
                                contributorArrayList);
                        lvAvaialbleContributors.setAdapter(contributionListAdapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }


