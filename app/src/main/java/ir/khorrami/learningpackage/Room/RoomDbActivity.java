package ir.khorrami.learningpackage.Room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import ir.khorrami.learningpackage.R;
import ir.khorrami.learningpackage.Room.Dao.AppDatabase;
import ir.khorrami.learningpackage.Room.Dao.EmployeeDao;
import ir.khorrami.learningpackage.Room.Entity.Employee;

public class RoomDbActivity extends AppCompatActivity {

    Button btnList,btnInsert;
    AppDatabase db;
    EmployeeDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_db);

        btnList = findViewById(R.id.btn_List);
        btnInsert = findViewById(R.id.btn_Insert);


        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "EmployeeSystem").build();

                userDao = db.employeeDao();
                Employee employee = new Employee("Reza", "Khorrami");
                userDao.insert(employee);
                Log.d("Employee :", "Inserted");
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Employee> employeeList = userDao.getAll();

                for (Employee employee : employeeList
                ) {
                    Log.d("EmployeeName : ", employee.getFirstName());
                }
            }
        });

    }
}