package com.example.vaccines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void signupPressed(View view) {

        /* get View object and set variable... */
        TextView tvResults = (TextView)findViewById(R.id.tvResults);
        String priority;
        String name = ((EditText) findViewById(R.id.etName)).getText().toString();
        String age = ((EditText) findViewById(R.id.etAge)).getText().toString();
        String phoneNumber = ((EditText) findViewById(R.id.etPhoneNumber)).getText().toString();

        /* get Database Object */
        MyDatabase db = MyDatabase.getDatabase(this);
        PatientDAO patientDAO = db.patientDAO();

        /* build priority based on rule......... 1: age over 80, 2:over 65, 3:over 40 or phone number starting the numbers 237 */
        if(Integer.valueOf(age) >= 80) priority = "1";
        else if(Integer.valueOf(age) >= 65) priority = "2";
        else if(Integer.valueOf(age) >= 40) priority = "3";
        else if (phoneNumber.startsWith("237")) priority = "3";
        else {
            priority = "No priority";
            Toast.makeText(this,"You don't have the vaccine Eligibility",Toast.LENGTH_SHORT).show();
            tvResults.setText(priority);
            return;
        }

        /* save patient info into the database.. */
        patientDAO.insertUser(new Patient(name,age,phoneNumber,priority));
        Toast.makeText(this,"Add user Sucessfully...",Toast.LENGTH_SHORT).show();
        tvResults.setText("Priority : " + priority);
    }
    public void checkCurrentListPressed(View view) {
        Intent i = new Intent(this, ActivityPatientsList.class);
        startActivity(i);
    }
}