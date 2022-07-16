package pasha.app.syncproject.Activities.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import pasha.app.syncproject.Room.Entities.Employee;
import pasha.app.syncproject.R;

class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView email,firstName,lastName,lastUpdated,hiredDate,employeeId;

    private EmployeeViewHolder(View itemView) {
        super(itemView);
        email = itemView.findViewById(R.id.email);
        firstName = itemView.findViewById(R.id.first_name);
        lastName = itemView.findViewById(R.id.last_name);
        lastUpdated = itemView.findViewById(R.id.last_updated);
        hiredDate = itemView.findViewById(R.id.hired_date);
        employeeId = itemView.findViewById(R.id.employee_id);
    }

    private String getDate(long milliSeconds)
    {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public void bind(Employee employee, Context context) {
        email.setText(employee.getEmail());
        firstName.setText(employee.getFirstName());
        lastName.setText(employee.getLastName());
        hiredDate.setText(employee.getHireDate());
        employeeId.setText(String.valueOf(employee.getEmployeeId()));

        long lastUpdatedMs = employee.getLast_updated();

        // using string placeholder
        // check string Resource
        lastUpdated.setText(context.getString(R.string.last_updated,getDate(lastUpdatedMs)));
    }

    static EmployeeViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_layout, parent, false);
        return new EmployeeViewHolder(view);
    }
}
