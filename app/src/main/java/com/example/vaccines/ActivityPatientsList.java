package com.example.vaccines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivityPatientsList extends AppCompatActivity {

    private ListView lvPatients;
    List<Patient> patients =  new ArrayList<>();
    PatientsAdapter myAdapter;
    MyDatabase db;
    PatientDAO patientDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2_vaccines_list);
        loadPatientInf();
    }

    public void loadPatientInf(){
        lvPatients = (ListView) findViewById(R.id.lvPatients);
        db = MyDatabase.getDatabase(this);patientDAO = db.patientDAO();
        patients = patientDAO.getAllUsers();
        myAdapter = new PatientsAdapter(this,patients);
        lvPatients.setAdapter(myAdapter);
    }

    public void goBackPressed(View view) {
        // goes back to the previous screen
        finish();
    }

    public void sortPressed(View view) {
        Collections.sort(patients, new Comparator<Patient>(){
            public int compare(Patient o1, Patient o2)
            {
                return o1.getPriority().compareTo(o2.getPriority());
            }
        });
        myAdapter.notifyDataSetChanged();
    }

    public void clearListPressed(View view) {
        patientDAO.deleteAll();
        patients.clear();
        myAdapter.notifyDataSetChanged();
    }

}