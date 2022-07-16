package pasha.app.syncproject.Repositories.External.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Create 1 instance of retrofit for whole app .
// Note that the api link is hardcoded here
// for the sake of this coding assesement and scalability of this
// project
public class RetrofitInstance {

    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl("https://pre-screening.free.beeceptor.com/")
                // convert json response to java class object
                // reason for employee private vars to match json result .
                // no need to serialize the property name;

                // this makes the setters of the java class (Employee)
                // not used .
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
