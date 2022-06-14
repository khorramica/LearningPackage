package ir.khorrami.learningpackage.RxJava.Just;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.reactivex.rxjava3.core.Observable;
import ir.khorrami.learningpackage.R;

public class RxJava_JustActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_just);

        Observable<Object> observable = Observable.just("1", "A", "3.2", "def");
        observable.subscribe(item -> System.out.println("RxJAVA_Test : " +item),error-> error.printStackTrace(),()-> System.out.println("Done"));
    }
}