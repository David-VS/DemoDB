package be.ehb.demodb.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import be.ehb.demodb.model.entities.Person;

public class PersonViewModel extends AndroidViewModel {

    private PersonDatabase mPersonDatabase;
    private LiveData<List<Person>> mPersonList;


    public PersonViewModel(@NonNull Application application) {
        super(application);
        mPersonDatabase = PersonDatabase.getInstance(application);
    }

    public LiveData<List<Person>> getmPersonList() {
        return mPersonDatabase.getPersonDAO().getAllPersons();
    }

    public void insertPerson(Person p){
        PersonDatabase.databaseExecutor.execute(()->{
            mPersonDatabase.getPersonDAO().insertPerson(p);
        });
    }


}
