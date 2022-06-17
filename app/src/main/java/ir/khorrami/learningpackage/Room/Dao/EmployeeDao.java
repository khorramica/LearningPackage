package ir.khorrami.learningpackage.Room.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ir.khorrami.learningpackage.Room.Entity.Employee;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM Employee")
    LiveData< List<Employee>> getAll();

    @Query("SELECT * FROM Employee WHERE id in (:id)")
    List<Employee> getById(Integer id);

    @Query("SELECT * FROM Employee WHERE FirstName LIKE :fName AND Lastname LIKE :lName LIMIT 1")
    Employee findByName(String fName, String lName);

    @Insert
    void insert(Employee employee);

    @Insert
    void insertAll(Employee...employees);

    @Delete
    void delete(Employee employee);

    @Update
    void update(Employee employee);

}
