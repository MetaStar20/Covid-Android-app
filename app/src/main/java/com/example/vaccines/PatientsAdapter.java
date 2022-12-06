package com.example.vaccines;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PatientsAdapter extends ArrayAdapter<Patient> {
    Context ctx;
    public PatientsAdapter(Context context, List<Patient> patients) {
        super(context, 0, patients); ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Patient patient = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout, parent, false);
        }

        TextView tvPriority = (TextView) convertView.findViewById(R.id.tvPrority); tvPriority.setText(patient.getPriority());
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName); tvName.setText(patient.getName());
        TextView tvAge = (TextView) convertView.findViewById(R.id.tvAge); tvAge.setText(patient.getAge());
        TextView tvPhoneNumber = (TextView) convertView.findViewById(R.id.tvPhoneNumber); tvPhoneNumber.setText(patient.getPhoneNumber());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + tvPhoneNumber.getText().toString().trim()));
                    ctx.startActivity(callIntent);
                } catch (Exception e) {
                    Log.e("AttractionDeatil","not Found Dial Activity");
                }
            }
        });
        return convertView;
    }
}