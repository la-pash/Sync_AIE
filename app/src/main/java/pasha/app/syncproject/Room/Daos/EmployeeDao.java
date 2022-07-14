package pasha.app.syncproject.Room.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import pasha.app.syncproject.Room.Entities.Employee;

@Dao
public interface EmployeeDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addEmployee(Employee employee);

    @Query("DELETE FROM employee_table")
    void deleteAllEmployees();

    @Query("SELECT * FROM employee_table ORDER BY employee_id ASC")
    LiveData<List<Employee>> getEmployeesList();
}
