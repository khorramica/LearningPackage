package ir.khorrami.learningpackage.RxJava.Create;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import ir.khorrami.learningpackage.R;

public class RxJava_Create extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_create);

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("My String 1");
                emitter.onNext("My String 2");
                emitter.onNext("My String 3");
            }
        });

//        Observer<String> observer = new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                Log.d("RxJAVA_Test" , s);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//
//        observable.subscribe(observer);

        observable.subscribe(item-> System.out.println("RxJAVA_Test : " + item),error->error.printStackTrace(),()-> System.out.println("Done"));

    }
}