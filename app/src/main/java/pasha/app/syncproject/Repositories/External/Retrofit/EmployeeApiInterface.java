package pasha.app.syncproject.Repositories.External.Retrofit;

import java.util.ArrayList;
import pasha.app.syncproject.Room.Entities.Employee;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeApiInterface {

    @GET("employees")
    Call<ArrayList<Employee>> getEmployees();
}
