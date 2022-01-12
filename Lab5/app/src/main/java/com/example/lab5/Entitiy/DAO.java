package com.example.lab5.Entitiy;

import android.app.Person;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {
    @Query("SELECT * FROM Person ORDER BY id Asc")
    List<Person> getAllData();
    @Query("SELECT * FROM Person ORDER BY Age Asc")
    List<Person> getAllDataSortedByAge();
    @Query("DELETE FROM Person")
    void deleteAll();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Person person);
    @Delete
    void delete(Person person);
}
