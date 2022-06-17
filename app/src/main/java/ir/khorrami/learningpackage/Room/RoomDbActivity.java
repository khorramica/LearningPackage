package ir.khorrami.learningpackage.Room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ir.khorrami.learningpackage.R;
import ir.khorrami.learningpackage.Room.Dao.AppDatabase;
import ir.khorrami.learningpackage.Room.Dao.EmployeeDao;
import ir.khorrami.learningpackage.Room.Entity.Employee;
import ir.khorrami.learningpackage.Room.ViewModel.RoomViewModel;

public class RoomDbActivity extends AppCompatActivity {

    Button btnList, btnInsert;
    AppDatabase db;
    EmployeeDao userDao;
    RoomViewModel roomViewModel;
    TextView txtName, txtFamily;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_db);
        txtName = findViewById(R.id.txt_Name);
        txtFamily = findViewById(R.id.txt_Family);
        context = this;

        roomViewModel = new ViewModelProvider(this).get(RoomViewModel.class);

        btnList = findViewById(R.id.btn_List);
        btnInsert = findViewById(R.id.btn_Insert);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String family = txtFamily.getText().toString();
                if (name.length() == 0 || family.length() == 0)
                    return;

                db = AppDatabase.getInstance(getApplicationContext());

                Employee employee = new Employee(name, family);
                roomViewModel.InsertEmployee(employee);
                Log.d("Employee :", "Inserted");
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                roomViewModel.getEmployeeList().observe((LifecycleOwner) context, new Observer<List<Employee>>() {
                    @Override
                    public void onChanged(List<Employee> employees) {
                        for (Employee employee : employees
                        ) {
                            Log.d("EmployeeName : ", employee.getFirstName() + " " + employee.getLastName());
                        }

                    }
                });
            }
        });
    }
}