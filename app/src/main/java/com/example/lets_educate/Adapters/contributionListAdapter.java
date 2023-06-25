package com.example.lets_educate.Adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.lets_educate.Models.Contributor;
import com.example.lets_educate.Models.Ngo;
import com.example.lets_educate.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class contributionListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Contributor> contributionarrayList;
    FirebaseDatabase database;
    FirebaseAuth auth;
    DatabaseReference myRef;
    DatabaseReference myRef1;
    DatabaseReference Contributordata;
    String dateTime;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    ProgressDialog dialog;
    SharedPreferences sh;
    Toast toast;
    Ngo ngodata;

    //private TextView serialNum, name, contactNum;
    public contributionListAdapter(Context context, ArrayList<Contributor> arrayList) {
        this.context = context;
        this.contributionarrayList = arrayList;
    }

    @Override
    public int getCount() {
        return contributionarrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.contributorlistitem, parent, false);

        dialog = new ProgressDialog(convertView.getContext());
        dialog.setTitle("Submit Message");
        dialog.setMessage("We Are Submitting Your Message!!!");
        toast = Toast.makeText(convertView.getContext(), "Message Submitted Successfully!!!", Toast.LENGTH_SHORT);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        dateTime = simpleDateFormat.format(calendar.getTime());

        String id = auth.getUid();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("NGOs");
        myRef1 = database.getReference("MessageNGOs");
        Contributordata = database.getReference("Institutes").child(id);

        final Contributor tempusers = contributionarrayList.get(position);

        TextView instituteName = convertView.findViewById(R.id.tvInstituteName);
        TextView instituteAddress = convertView.findViewById(R.id.tvaddress);
        TextView tvsittingCapacity = convertView.findViewById(R.id.tvsittingCapacity);
        TextView tvnumberofcomputers = convertView.findViewById(R.id.tvnumberofcomputers);
        TextView tvlaborclass = convertView.findViewById(R.id.tvlaborclass);
        TextView tvprojector = convertView.findViewById(R.id.tvprojector);
        TextView tvboard = convertView.findViewById(R.id.tvboard);
        Button iwanttohelp = convertView.findViewById(R.id.btnIwanttoHelp);

        instituteName.setText("Institute Name: "+contributionarrayList.get(position).getInstituteName());
        instituteAddress.setText("Institute Address:"+contributionarrayList.get(position).getInstituteAddress());
        tvsittingCapacity.setText("Sitting Capacity:"+contributionarrayList.get(position).getSittingCapacity());
        tvnumberofcomputers.setText("No. Of Computers:"+contributionarrayList.get(position).getNumberofComputers());
        tvlaborclass.setText("Class / Lab:"+contributionarrayList.get(position).getLaborclass());
        tvprojector.setText("Projector:"+contributionarrayList.get(position).getProjector());
        tvboard.setText("Board:"+contributionarrayList.get(position).getBoard());

        Contributordata.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               ngodata  = snapshot.getValue(Ngo.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        iwanttohelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();

                Log.d("ROCKSTAR","clicked"+id);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        dialog.dismiss();
                        Contributor users = new Contributor(tempusers.getInstituteName(),tempusers.getInstituteAddress()
                                ,tempusers.getSittingCapacity(),tempusers.getNumberofComputers(),
                                tempusers.getLaborclass(),tempusers.getProjector(),
                                tempusers.getBoard(),ngodata.getEmail(),ngodata.getAddress()
                                ,ngodata.getName(),ngodata.getPhoneno(),id
                                ,dateTime);
//                        Toast.makeText(, "Message Submit Successfully!!!", Toast.LENGTH_SHORT).show();
                        myRef.child(id).child("MessageNGOs").child(dateTime).setValue(users);
                        myRef1.child(id).child(dateTime).setValue(users);
                        toast.show();
                        Log.d("ROCKSTAR","clickedMessage Submit Successfully!!!");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
//                        Toast.makeText(this, "Error!!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return convertView;
    }
}
