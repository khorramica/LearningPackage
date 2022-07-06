package ir.khorrami.learningpackage.RxJava.BehaviorRelay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jakewharton.rxrelay3.BehaviorRelay;

import io.reactivex.rxjava3.observers.TestObserver;
import ir.khorrami.learningpackage.R;

public class RxJava_BehaviorRelayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_behavior_relay);

        BehaviorRelay<Integer> behaviorRelay = BehaviorRelay.create();
        TestObserver<Integer> firstObserver = TestObserver.create();
        TestObserver<Integer> secondObserver = TestObserver.create();

        behaviorRelay.accept(5);
        behaviorRelay.subscribe(firstObserver);
        behaviorRelay.accept(10);
        behaviorRelay.subscribe(secondObserver);
        behaviorRelay.accept(15);
        firstObserver.assertValues(5,10,15);
        secondObserver.assertValues(10,15);




    }
}