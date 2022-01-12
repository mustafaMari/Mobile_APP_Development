package com.example.lab5.Placeholder;

import android.app.Application;

import java.util.List;

public class Repository {
    private static DAO dao;

    public Repository (Application context){
        DB db = DB.getDb(context);
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
