package pasha.app.syncproject.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pasha.app.syncproject.Repositories.Local.EmployeeRepository;
import pasha.app.syncproject.Room.Entities.Employee;

public class EmployeeViewModel extends AndroidViewModel {

    private EmployeeRepository mRepository;

    private final LiveData<List<Employee>> allEmployees;

    public EmployeeViewModel(Application application) {
        super(application);
        mRepository = new EmployeeRepository(application);
        allEmployees = mRepository.getAllEmployees();
    }

    LiveData<List<Employee>> getAllEmployees() { return allEmployees; }

    public void insert(Employee employee) { mRepository.insert(employee); }
}
