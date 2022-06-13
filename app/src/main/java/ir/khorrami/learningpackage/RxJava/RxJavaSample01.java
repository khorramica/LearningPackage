package ir.khorrami.learningpackage.RxJava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.observers.BlockingObserver;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.khorrami.learningpackage.R;

public class RxJavaSample01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_sample01);

        //Just
        Observable<String> observable = new ObservableCreate<String>(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("Reza");
                emitter.onNext("Ali");
                emitter.onComplete();
            }
        });


        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("eeeeeeeeeeeeeeeeee", s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        observable.subscribe(observer);

//        Observable<String> animals = Observable.just("Eagle", "Bee", "Lion", "Dog", "Wolf");
//        animals.
//                observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.d("MyLog : ", "Disposed");
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull String s) {
//                        Log.d("MyLog : ", s);
//
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.d("MyLog : ", e.getMessage());
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d("MyLog : ", "Completed");
//
//                    }
//                });

    }
}