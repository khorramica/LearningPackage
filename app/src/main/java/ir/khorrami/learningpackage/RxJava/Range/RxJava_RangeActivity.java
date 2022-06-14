package ir.khorrami.learningpackage.RxJava.Range;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Observer;

import io.reactivex.rxjava3.core.Observable;
import ir.khorrami.learningpackage.R;

public class RxJava_RangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_range);
        String str = "My name is REZA";
        Observable<Integer> observable = Observable.range(0, str.length());

        Observable<Character> characters = observable.map(index -> str.charAt(index));

        characters.subscribe(item -> System.out.println("RxJAVA_Test : " + item), error -> error.printStackTrace(), () -> System.out.println("Done"));
    }
}