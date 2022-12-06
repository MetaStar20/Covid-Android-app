package com.example.vaccines;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PatientDAO {
    @Query("SELECT * FROM patients")
    List<Patient> getAllUsers();

    @Query("SELECT * FROM patients WHERE id=:id")
    List<Patient> getUser(int id);

    @Insert
    void insertAll(Patient... users);

    @Insert
    void insertUser(Patient user);

    @Query("DELETE FROM patients")
    void deleteAll();

}
