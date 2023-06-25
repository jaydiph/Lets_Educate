package com.example.lets_educate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lets_educate.Models.Teacher;
import com.example.lets_educate.R;

import java.util.ArrayList;

public class TeacherprofileAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Teacher> teachersArrayList;
    public TeacherprofileAdapter(Context context, ArrayList<Teacher> arrayList) {
        this.context = context;
        this.teachersArrayList = arrayList;
    }
    @Override
    public int getCount() {
        return teachersArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i,View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.teacherprofilelist, parent, false);
        TextView firstname = convertView.findViewById(R.id.firstnamestudent);
        TextView lastname = convertView.findViewById(R.id.lastnamestudent);
        TextView address = convertView.findViewById(R.id.addressstudentretrive);
        TextView phone = convertView.findViewById(R.id.phonenostudentretrive);
        TextView qualification = convertView.findViewById(R.id.qualificationstudentretrive);
        TextView intrest = convertView.findViewById(R.id.intrestteacher);
        TextView subject = convertView.findViewById(R.id.favsubjectstudentretrive);
        TextView skillknowledge = convertView.findViewById(R.id.skill_knowledgeteacher);

        firstname.setText("First Name :"+teachersArrayList.get(i).getFname());
        lastname.setText("Last Name :"+teachersArrayList.get(i).getLname());
        address.setText("Address :"+teachersArrayList.get(i).getAddress());
        phone.setText("Phone No :"+teachersArrayList.get(i).getPhoneno());
        qualification.setText("Qualification:"+teachersArrayList.get(i).getQualification());
        skillknowledge.setText("Skill & Knowledge:"+teachersArrayList.get(i).getSkillknowledge());
        intrest.setText("Your Intrest:"+teachersArrayList.get(i).getIntrest());
        subject.setText("Your Subject:"+teachersArrayList.get(i).getSubject());

        return convertView;
    }
}
