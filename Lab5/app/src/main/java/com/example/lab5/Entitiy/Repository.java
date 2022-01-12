package com.example.lab5.Entitiy;

import android.app.Application;
import android.app.Person;

import java.util.List;

public class Repository {
    private static List<Person> people;
    private static DAO dao;
    private static DB db;
    public Repository (Application context){
        db = DB.getDb(context);
        dao = db.dao();
    }
    public List<Person> getAllPeople(){
        people = dao.getAllData();
        return people;
    }
    public void insertPerson (Person person){
        dao.insert(person);
    }
    public void deletePerson (Person person){
        dao.delete(person);
    }
}
