package ir.khorrami.learningpackage.MVVM.Heros.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.security.PublicKey;
import java.util.List;

import ir.khorrami.learningpackage.Common.Consts;
import ir.khorrami.learningpackage.MVVM.Heros.api.ApiClient;
import ir.khorrami.learningpackage.MVVM.Heros.model.Heros;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroViewModel extends ViewModel {

    MutableLiveData<List<Heros>> heroList;

    public MutableLiveData<List<Heros>> getHeroes() {

        if (heroList == null)
            heroList = new MutableLiveData<List<Heros>>();


        Call<List<Heros>> call = ApiClient.GetInstance().GetApi(Consts.HERO_BASE_URL).GetHeroList();
        call.enqueue(new Callback<List<Heros>>() {
            @Override
            public void onResponse(Call<List<Heros>> call, Response<List<Heros>> response) {
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Heros>> call, Throwable t) {

            }
        });

        return heroList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
