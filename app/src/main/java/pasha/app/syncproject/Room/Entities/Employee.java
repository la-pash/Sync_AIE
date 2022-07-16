package pasha.app.syncproject.Room.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee_table")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int employeeId;

    // names of vars are also used as in the SQL table
    // name pattern taken from json response .
    private String firstName;
    private String lastName;
    private String email;
    private String hireDate;
    private long last_updated;

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLast_updated(long last_fetched) {
        last_updated = last_fetched;
    }

    public String getEmail() {
        return email;
    }

    public long getLast_updated() {
        return last_updated;
    }

    public String getHireDate() {
        return hireDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Employee() {}
}
