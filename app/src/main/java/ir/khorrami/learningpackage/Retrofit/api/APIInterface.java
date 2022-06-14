package ir.khorrami.learningpackage.Retrofit.api;

import java.util.List;

import ir.khorrami.learningpackage.Retrofit.model.Person;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("marvel")
    Call<List<Person>> getPersons();
}
