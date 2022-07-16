package pasha.app.syncproject.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.util.List;

import pasha.app.syncproject.Repositories.External.EmployeeWorker;
import pasha.app.syncproject.Repositories.Local.EmployeeRepository;
import pasha.app.syncproject.Room.Entities.Employee;

public class EmployeeViewModel extends AndroidViewModel {

    private EmployeeRepository mRepository;

    private WorkManager mWorkManager;

    private final LiveData<List<Employee>> allEmployees;

    public EmployeeViewModel(Application application) {
        super(application);
        mWorkManager = WorkManager.getInstance(application);

        mRepository = new EmployeeRepository(application);
        allEmployees = mRepository.getAllEmployees();
    }

    public LiveData<List<Employee>> getAllEmployees() {
        // execute the background work defined inside
        // the doWork() .
        mWorkManager.enqueue(OneTimeWorkRequest.from(EmployeeWorker.class));

        // list of employees are fetched and cached to room .
        return allEmployees;
    }
}
