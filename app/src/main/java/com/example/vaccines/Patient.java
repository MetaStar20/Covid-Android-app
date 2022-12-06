package com.example.vaccines;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patients")
public class Patient {
    @PrimaryKey(autoGenerate = true)
    @NonNull

    private int id;

    @ColumnInfo(name = "name")
    private String  name;

    @ColumnInfo(name = "phoneNumber")
    private String  phoneNumber;

    @ColumnInfo(name = "age")
    private String  age;

    @ColumnInfo(name = "priority")
    private String  priority;

    public Patient(int id, String name, String age,String phoneNumber){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Patient(String name,  String age,String phoneNumber, String priority){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.priority = priority;
    }

    public Patient(){
        name = phoneNumber = age = "";
    }

    public int getId() { return  this.id; }

    public void setId(int id) { this.id = id;  }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return this.phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAge() { return this.age; }

    public void setAge(String age) { this.age = age;}

    public String getPriority() { return this.priority; }

    public void setPriority(String priority) {this.priority = priority;}


}
