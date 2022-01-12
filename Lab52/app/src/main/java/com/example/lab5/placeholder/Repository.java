package com.example.lab5.placeholder;

import android.app.Application;
import android.app.Person;

import java.util.List;

public class Repository {
    private static DAO dao;
    private static DB db;
    public Repository (Application context){
        db = DB.getDb(context);
        dao = db.dao();
    }
    public List<ItemData> getAllPeople(){

        return dao.getAllData();
    }
    public void insertPerson (ItemData person){
        dao.insert(person);
    }
    public void deletePerson (ItemData person){
        dao.delete(person);
    }
}
