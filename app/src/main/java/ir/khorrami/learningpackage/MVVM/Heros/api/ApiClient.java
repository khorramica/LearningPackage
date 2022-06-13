package ir.khorrami.learningpackage.MVVM.Heros.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    static Retrofit retrofit;
    static ApiInterface apiInterface;
    static ApiClient apiClient;
    public static ApiClient GetInstance()
    {
        if(apiClient == null)
            apiClient = new ApiClient();

        return apiClient;
    }

    public ApiInterface GetApi(String url)
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        return apiInterface;
    }
}
