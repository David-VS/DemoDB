package be.ehb.demodb.model.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.threeten.bp.LocalDate;


@Entity
public class Person {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate dob;

    public Person() {
    }

    @Ignore
    public Person(long id, String firstname, String lastname, LocalDate dob) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
