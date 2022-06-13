package ir.khorrami.learningpackage.RxJava.just;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Observable;
import android.os.Bundle;
import android.util.Log;


import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import ir.khorrami.learningpackage.R;

public class JustObserverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_observer);

        io.reactivex.rxjava3.core.Observable<String> just = io.reactivex.rxjava3.core.Observable.just("Reza","Mehrad");

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("Learning RxJava: ","onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("Learning RxJava: ",s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("Learning RxJava: ","Completed");

            }
        };

        just.subscribe(observer);

    }
}