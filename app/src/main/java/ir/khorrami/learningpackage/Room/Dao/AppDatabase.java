package ir.khorrami.learningpackage.Room.Dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ir.khorrami.learningpackage.Room.Entity.Employee;

@Database(entities = Employee.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();

    public static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "EmployeeDB").build();
        return appDatabase;
    }
}
