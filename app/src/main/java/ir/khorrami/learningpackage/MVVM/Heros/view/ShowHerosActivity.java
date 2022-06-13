package ir.khorrami.learningpackage.MVVM.Heros.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import ir.khorrami.learningpackage.MVVM.Heros.adapter.HeroAdapter;
import ir.khorrami.learningpackage.MVVM.Heros.model.Heros;
import ir.khorrami.learningpackage.MVVM.Heros.viewmodel.HeroViewModel;
import ir.khorrami.learningpackage.R;

public class ShowHerosActivity extends AppCompatActivity {

    RecyclerView rvHeroesList;
    HeroAdapter heroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_heros);
        rvHeroesList = findViewById(R.id.rv_HeroesList);
        rvHeroesList.setHasFixedSize(true);
        rvHeroesList.setLayoutManager(new LinearLayoutManager(this));

        HeroViewModel heroViewModel =new ViewModelProvider(this).get(HeroViewModel.class);
//        HeroViewModel heroViewModel =new ViewModelProvider().get(HeroViewModel.class);

        heroViewModel.getHeroes()
                .observe(this, new Observer<List<Heros>>() {
                    @Override
                    public void onChanged(List<Heros> heroes) {
                        heroAdapter = new HeroAdapter(getApplicationContext(), heroes);
                        rvHeroesList.setAdapter(heroAdapter);
                    }
                });
    }
}