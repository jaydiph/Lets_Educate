package com.example.lets_educate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lets_educate.Models.Ngo;
import com.example.lets_educate.R;

import java.util.ArrayList;

public class NgoProfileAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Ngo> ngoArrayList;
    public NgoProfileAdapter(Context context, ArrayList<Ngo> arrayList) {
        this.context = context;
        this.ngoArrayList = arrayList;
    }

    @Override
    public int getCount() {
        return ngoArrayList.size();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.ngoprofilelist, parent, false);
        TextView name = convertView.findViewById(R.id.namengoretrive);
        TextView email = convertView.findViewById(R.id.emailngoretrive);
        TextView phone = convertView.findViewById(R.id.phonenongoretrive);
        TextView address = convertView.findViewById(R.id.addressngoretrive);

        name.setText(" Name :"+ngoArrayList.get(i).getName());
        email.setText("Email :"+ngoArrayList.get(i).getEmail());
        phone.setText("Phone No :"+ngoArrayList.get(i).getPhoneno());
        address.setText("Address :"+ngoArrayList.get(i).getAddress());


        return convertView;
    }
}
