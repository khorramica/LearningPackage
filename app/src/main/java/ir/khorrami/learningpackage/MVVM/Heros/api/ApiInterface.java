package ir.khorrami.learningpackage.MVVM.Heros.api;

import java.util.List;

import ir.khorrami.learningpackage.MVVM.Heros.model.Heros;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("marvel")
    Call<List<Heros>> GetHeroList();
}
