package pasha.app.syncproject.Activities.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
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

    public void bind(Employee employee) {
        email.setText(employee.getEmail());
        firstName.setText(employee.getFirst_name());
        lastName.setText(employee.getLast_name());
        lastUpdated.setText(employee.getLast_updated());
        hiredDate.setText(employee.getHire_date());
        employeeId.setText(employee.getEmployee_id());
    }

    static EmployeeViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_layout, parent, false);
        return new EmployeeViewHolder(view);
    }
}
