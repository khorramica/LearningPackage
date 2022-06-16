package ir.khorrami.learningpackage.Room.Dao;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;

import ir.khorrami.learningpackage.Room.Entity.Employee;

@Database(entities = {Employee.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}
