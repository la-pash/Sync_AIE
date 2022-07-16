package pasha.app.syncproject.Repositories.External;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.ArrayList;
import java.util.Calendar;

import pasha.app.syncproject.Repositories.External.Retrofit.EmployeeApiInterface;
import pasha.app.syncproject.Repositories.External.Retrofit.RetrofitInstance;
import pasha.app.syncproject.Repositories.Local.EmployeeRepository;
import pasha.app.syncproject.Room.EmployeeRoomDatabase;
import pasha.app.syncproject.Room.Entities.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EmployeeWorker extends Worker {

    private Retrofit retrofit;
    private EmployeeRepository mRepository;

    public EmployeeWorker(
            @NonNull Context appContext,
            @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
        retrofit = RetrofitInstance.getRetrofitInstance();

        // to get access to the room from the local repo .
        mRepository = new EmployeeRepository((Application) getApplicationContext());
    }

    @NonNull
    @Override
    public Result doWork() {
        EmployeeApiInterface employeeInterface =
                retrofit.create(EmployeeApiInterface.class);

        Call<ArrayList<Employee>> call =
                    employeeInterface.getEmployees();

        call.enqueue(new Callback<ArrayList<Employee>>() {
            @Override
            public void onResponse(Call<ArrayList<Employee>> call, Response<ArrayList<Employee>> response) {
                // still the response we want is not guaranteed so far .
                // e.g response 404 is still considered a response
                if(!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Code : "+response.code(),
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // we are good to go .
                // response code 200
                ArrayList<Employee> data = response.body();

                // this call should happen on a non-UI thread or your app will throw an exception.
                // Room ensures that you're not doing any long running operations on the main thread,
                // blocking the UI.
                EmployeeRoomDatabase.databaseWriteExecutor.execute(() -> {

                    // lastFetched taken immediately after OkHttp received this
                    // response's headers from the network.

                    // lastFetched = now() in ms - time received response .

                    long lastFetched = response.raw().receivedResponseAtMillis();

                    mRepository.insert(data, lastFetched);
                });
            }

            @Override
            public void onFailure(Call<ArrayList<Employee>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return Result.success();
    }
}
