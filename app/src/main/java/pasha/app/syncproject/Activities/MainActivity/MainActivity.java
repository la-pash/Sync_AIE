package pasha.app.syncproject.Activities.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import pasha.app.syncproject.Activities.Adapters.EmployeeListAdapter;
import pasha.app.syncproject.R;
import pasha.app.syncproject.Services.ForegroundService;
import pasha.app.syncproject.ViewModels.EmployeeViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        EmployeeListAdapter adapter = new EmployeeListAdapter(new ArrayList<>(),getApplicationContext());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        EmployeeViewModel employeeViewModel = new ViewModelProvider(this).
                get(EmployeeViewModel.class);

        employeeViewModel.getAllEmployees().observe(this, employees -> {
            adapter.updateList(employees);
            adapter.notifyDataSetChanged();
        });

        final Button fab = findViewById(R.id.service_button);
        fab.setOnClickListener(v -> {
            Intent serviceIntent = new Intent(MainActivity.this,
                    ForegroundService.class);
            startService(serviceIntent);
        });
    }
}