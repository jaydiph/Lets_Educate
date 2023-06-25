package com.example.lets_educate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lets_educate.Models.Student;
import com.example.lets_educate.R;

import java.util.ArrayList;

public class StudentProfileAdapter extends BaseAdapter {



    private Context context;
    private ArrayList<Student> studentArrayList;
    //private TextView serialNum, name, contactNum;
    public StudentProfileAdapter(Context context, ArrayList<Student> arrayList) {
        this.context = context;
        this.studentArrayList = arrayList;
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
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
    public View getView(int position,  View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.studentprofilelist, parent, false);
        TextView firstname = convertView.findViewById(R.id.firstnamestudent);
        TextView lastname = convertView.findViewById(R.id.lastnamestudent);
        TextView email = convertView.findViewById(R.id.emailstudentretrive);
        TextView address = convertView.findViewById(R.id.addressstudentretrive);
        TextView phone = convertView.findViewById(R.id.phonenostudentretrive);
        TextView schoolcollege = convertView.findViewById(R.id.schoolcollegestudentretrive);
        TextView qualification = convertView.findViewById(R.id.qualificationstudentretrive);
        TextView favsubject = convertView.findViewById(R.id.favsubjectstudentretrive);
        TextView percentage = convertView.findViewById(R.id.previousyearpercentagestudentretrive);

        firstname.setText("First Name :"+studentArrayList.get(position).getFname());
        lastname.setText("Last Name :"+studentArrayList.get(position).getLname());
        email.setText("Email :"+studentArrayList.get(position).getEmail());
        address.setText("Address :"+studentArrayList.get(position).getAddress());
        phone.setText("Phone No :"+studentArrayList.get(position).getPhoneno());
        schoolcollege.setText("School/College :"+studentArrayList.get(position).getSchool_college());
        qualification.setText("Qualification:"+studentArrayList.get(position).getQualification());
        favsubject.setText("Favourite Subject :"+studentArrayList.get(position).getFav_subject());
        percentage.setText("Previous Percentage :"+studentArrayList.get(position).getPercentage());

        return convertView;
    }
}
