package ir.khorrami.learningpackage.Prpgressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import ir.khorrami.learningpackage.Prpgressbar.widgets.SlideToUnlock;
import ir.khorrami.learningpackage.R;


public class SeekbarActivity extends AppCompatActivity implements SlideToUnlock.OnUnlockListener {
    private SlideToUnlock slideToUnlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        slideToUnlock = findViewById(R.id.slidetounlock);
        slideToUnlock.setOnUnlockListener(this);
    }

    @Override
    public void onUnlock() {
        Toast.makeText(this, "Unlocked", Toast.LENGTH_SHORT).show();
    }
}