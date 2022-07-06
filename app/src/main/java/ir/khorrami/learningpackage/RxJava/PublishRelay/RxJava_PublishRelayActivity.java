package ir.khorrami.learningpackage.RxJava.PublishRelay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jakewharton.rxrelay3.PublishRelay;

import io.reactivex.rxjava3.observers.TestObserver;
import ir.khorrami.learningpackage.R;

public class RxJava_PublishRelayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_publish_relay);


        PublishRelay<Integer> publishRelay = PublishRelay.create();
        TestObserver<Integer> firstObserver = TestObserver.create();
        TestObserver<Integer> secondObserver = TestObserver.create();

        publishRelay.subscribe(firstObserver);
//        firstObserver.assertSubscribed();
        publishRelay.accept(5);
        publishRelay.accept(10);

        publishRelay.subscribe(secondObserver);
//        secondObserver.assertSubscribed();
        publishRelay.accept(15);
        firstObserver.assertValues(5, 10, 15);
        secondObserver.assertValue(15);


    }
}