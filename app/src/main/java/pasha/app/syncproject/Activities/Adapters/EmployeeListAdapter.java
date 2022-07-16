package pasha.app.syncproject.Activities.Adapters;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import pasha.app.syncproject.Room.Entities.Employee;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    private List<Employee> list;
    private Context context;

    public EmployeeListAdapter(List<Employee> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // Method used to update adapter list
    // with data fetched from api
    public void updateList(List<Employee> list) {
        this.list = list;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return EmployeeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.bind(list.get(position),context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
