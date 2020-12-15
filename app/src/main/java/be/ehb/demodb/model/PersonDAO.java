package be.ehb.demodb.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import be.ehb.demodb.model.entities.Person;

@Dao
public interface PersonDAO {

    @Insert
    void insertPerson(Person p);//insert row in table

    @Update
    void updatePerson(Person p); //if primary key exists in table, update that row

    @Delete
    void deletePerson(Person p); //if primary key exists in table, deletes that row

    @Query("SELECT * FROM Person ORDER BY lastname")
    LiveData<List<Person>> getAllPersons();

    @Query("SELECT * FROM Person WHERE lastname LIKE :name")
    LiveData<List<Person>> findPersonsByName(String name); //escape karakters should go in param e.g. name = "%van%"
}
