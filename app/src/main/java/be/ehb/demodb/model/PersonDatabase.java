package be.ehb.demodb.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import be.ehb.demodb.model.entities.Person;
import be.ehb.demodb.model.util.DateConverters;

@Database(version = 1, entities = {Person.class})
@TypeConverters({DateConverters.class})
public abstract class PersonDatabase extends RoomDatabase {

    private static PersonDatabase instance;

    //nodig voor threads
    public static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(4);

    public static PersonDatabase getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context, PersonDatabase.class, "persons.sqlite").build();
        }
        return instance;
    }

    public abstract PersonDAO getPersonDAO();
}
