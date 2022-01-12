package com.example.lab5.Placeholder;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {ItemData.class}, version = 1)
public abstract class DB extends RoomDatabase {
    public abstract DAO dao();
    private static DB db;
    static synchronized DB getDb(final Context context){
        if (db == null){
            db = Room.databaseBuilder(context.getApplicationContext(),DB.class,"Person_db")
                    .allowMainThreadQueries().build();
        }
        return db;
    }
    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
