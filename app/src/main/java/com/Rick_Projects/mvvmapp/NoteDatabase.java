package com.Rick_Projects.mvvmapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao(); /*Will be used to access the DAO*/

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room
                    .databaseBuilder(
                            context.getApplicationContext(),
                            NoteDatabase.class,
                            "note_database" /*The Name of our Database*/
                    )
                    .fallbackToDestructiveMigration()/*Deletes the previous db schema when we
                     increase db version number/Migrate to new db*/
                    .build();
        }

        return instance;
    }
}
