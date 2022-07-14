package pasha.app.syncproject.Repositories.Local;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import pasha.app.syncproject.Room.Daos.EmployeeDao;
import pasha.app.syncproject.Room.EmployeeRoomDatabase;
import pasha.app.syncproject.Room.Entities.Employee;

public class EmployeeRepository {

    private EmployeeDao employeeDao;
    private LiveData<List<Employee>> allEmployees;

    public EmployeeRepository(Application application) {
        EmployeeRoomDatabase db = EmployeeRoomDatabase.getDatabase(application);
        employeeDao = db.employeeDao();
        allEmployees = employeeDao.getEmployeesList();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Employee>> getAllEmployees() {
        return allEmployees;
    }

    // this call should happen on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Employee employee) {
        EmployeeRoomDatabase.databaseWriteExecutor.execute(() -> {
            employeeDao.addEmployee(employee);
        });
    }
}
