package ir.khorrami.learningpackage.RxJava.Single;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;
import ir.khorrami.learningpackage.R;

public class SingleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);


        Observable<Integer> integerObservable = Observable.just(1, 7, 3,6);

        Single<Boolean> booleanSingle = integerObservable.any(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer % 3 == 0;
            }
        });

        booleanSingle.subscribe(l -> System.out.println("Subscriber #1 onNext: " + l), (Throwable e) -> System.out.println("onError"));


        Single<Long> integerSingle = integerObservable.count();


        integerSingle.subscribe(l -> System.out.println("Subscriber #1 onNext: " + l), (Throwable e) -> System.out.println("onError"));
    }
}