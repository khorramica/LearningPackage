package ir.khorrami.learningpackage.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import ir.khorrami.learningpackage.Common.Consts;
import ir.khorrami.learningpackage.R;
import ir.khorrami.learningpackage.Retrofit.api.APIClient;
import ir.khorrami.learningpackage.Retrofit.api.APIInterface;
import ir.khorrami.learningpackage.Retrofit.model.Person;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {
APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        apiInterface = APIClient.getApiClint(Consts.PERSON_BASE_URL).create(APIInterface.class);
        Call<List<Person>> call = apiInterface.getPersons();

        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {

                for (Person person:response.body()
                     ) {
                    System.out.println(" Name is : " +  person.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {

            }
        });
    }
}