package pasha.app.syncproject.Room.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee_table")
public class Employee {

    @PrimaryKey
    @NonNull
    private int employee_id;

    // names of vars are also used as in the SQL table
    private String first_name;
    private String last_name;
    private String email;
    private int hire_date;
    private int last_updated;

    public void setHire_date(int hire_date) {
        this.hire_date = hire_date;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_updated(int last_updated) {
        this.last_updated = last_updated;
    }

    public String getEmail() {
        return email;
    }

    public int getLast_updated() {
        return last_updated;
    }

    public int getHire_date() {
        return hire_date;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public Employee() {}
}
