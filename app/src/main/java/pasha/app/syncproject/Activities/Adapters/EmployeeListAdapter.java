package pasha.app.syncproject.Activities.Adapters;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import pasha.app.syncproject.Room.Entities.Employee;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    private List<Employee> list;

    public EmployeeListAdapter(List<Employee> list) {
        this.list = list;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return EmployeeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
