package com.example.lab5.placeholder;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Person")
public class ItemData {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "FirstName")
    public String firstName;
    @ColumnInfo(name = "LastName")
    public String lastName;
    @ColumnInfo(name = "Age")
    public int age;
    @ColumnInfo(name = "Sex")
    public String gender;

}
