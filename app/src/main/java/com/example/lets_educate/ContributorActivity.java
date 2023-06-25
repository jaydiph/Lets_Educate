package com.example.lets_educate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.lets_educate.Models.Contributor;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ContributorActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    EditText edtInstituteName, edtInstituteAddress, edtSittingCapacity, edtNumberofComputers;
    Switch swlabclass, swprojector, swboard;
    Button btnSubmit;
    String labclass, projector, board;
    BottomNavigationView bottomNavigationView;

    FirebaseDatabase db;
    DatabaseReference root ;
    FirebaseUser user;
    Contributor contributor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributor);

        getSupportActionBar().setTitle("Institute Dashboard");

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.student_home);

        db = FirebaseDatabase.getInstance();
        //root = db.getReference().child("Contributors");
        user = FirebaseAuth.getInstance().getCurrentUser();
        initialize();
        contributor = new Contributor();


        swlabclass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    labclass = swlabclass.getTextOn().toString();
                    Log.v("DS","lab"+labclass);
                } else {
                    // The toggle is disabled
                }
            }
        });

        swprojector.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    projector = swprojector.getTextOn().toString();
                    Log.v("DS","lab"+projector);
                } else {
                    // The toggle is disabled
                }
            }
        });

        swboard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    board = swboard.getTextOn().toString();
                    Log.v("DS","lab"+board);
                } else {
                    // The toggle is disabled
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root = db.getReference().child("ContributorsMessages").child(FirebaseAuth.getInstance().getUid()).push();
                labclass = swlabclass.getTextOn().toString();
                projector = swprojector.getTextOn().toString();
                board = swboard.getTextOn().toString();

                Log.v("DS","rooot"+labclass+projector+board);
                addDataToFireBase( edtInstituteName.getText().toString(),
                        edtInstituteAddress.getText().toString(),
                        edtSittingCapacity.getText().toString(),
                        edtNumberofComputers.getText().toString(),
                        labclass, projector, board);

              String instituteName = edtInstituteName.getText().toString();
              String instituteaddress = edtInstituteAddress.getText().toString();
              String sitingcapacity = edtSittingCapacity.getText().toString();
              String noofcomputers = edtNumberofComputers.getText().toString();

                if(instituteName.isEmpty())
                {
                    edtInstituteName.setError("Email is empty");
                    edtInstituteName.requestFocus();
                    return;
                }
                if(instituteaddress.isEmpty())
                {
                    edtInstituteAddress.setError("Email is empty");
                    edtInstituteAddress.requestFocus();
                    return;
                }
                if(sitingcapacity.isEmpty())
                {
                    edtSittingCapacity.setError("Email is empty");
                    edtSittingCapacity.requestFocus();
                    return;
                }
                if(noofcomputers.isEmpty())
                {
                    edtNumberofComputers.setError("Email is empty");
                    edtNumberofComputers.requestFocus();
                    return;
                }


            }
        });

    }

    private void initialize() {
        edtInstituteName = findViewById(R.id.edtInstituteName);
        edtInstituteAddress = findViewById(R.id.edtaddress);
        edtSittingCapacity = findViewById(R.id.edtCapacity);
        edtNumberofComputers = findViewById(R.id.edtavailableComputer);

        swboard = findViewById(R.id.swWhiteBoard);
        swlabclass = findViewById(R.id.swlabclass);
        swprojector = findViewById(R.id.swprojector);

        btnSubmit = findViewById(R.id.btnSubmit);
    }

    private void addDataToFireBase(String instituteName, String instituteAddress, String sittingCapacity,
                                   String numberofComputers, String labOrClass, String projector,
                                   String board) {

        contributor.setInstituteName(instituteName);
        contributor.setInstituteAddress(instituteAddress);
        contributor.setSittingCapacity(sittingCapacity);
        contributor.setNumberofComputers(numberofComputers);
        contributor.setLaborclass(labOrClass);
        contributor.setProjector(projector);
        contributor.setBoard(board);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                root.setValue(contributor);
                Toast.makeText(ContributorActivity.this, "Data Inserted Sucessfully...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.teacherhome:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
                return true;

            case R.id.teacherhistory:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                return true;

            case R.id.teacherprofile:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
                return true;
        }
        return false;
    }
}