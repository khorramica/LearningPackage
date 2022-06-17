package ir.khorrami.learningpackage.Room.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ir.khorrami.learningpackage.Room.Dao.AppDatabase;
import ir.khorrami.learningpackage.Room.Dao.EmployeeDao;
import ir.khorrami.learningpackage.Room.Entity.Employee;

public class RoomViewModel extends AndroidViewModel {

    private EmployeeDao employeeDao;
    private AppDatabase appDatabase;
    private LiveData< List<Employee>> employeeList;

    public RoomViewModel(@NonNull Application application) {
        super(application);

        appDatabase = AppDatabase.getInstance(application);
        employeeDao = appDatabase.employeeDao();
        employeeList = employeeDao.getAll();
    }

    public LiveData<List<Employee>> getEmployeeList()
    {
        return employeeList;
    }

    public class InsertEmployeeAsync extends AsyncTask<Employee,Void,Void>{

        EmployeeDao mEmployeeDao;

        public InsertEmployeeAsync(EmployeeDao EmployeeDao) {
            this.mEmployeeDao = EmployeeDao;
        }


        @Override
        protected Void doInBackground(Employee... employees) {
            mEmployeeDao.insert(employees[0]);
            return null;
        }
    }

    public void InsertEmployee(Employee employee) {
        new InsertEmployeeAsync(employeeDao).execute(employee);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
