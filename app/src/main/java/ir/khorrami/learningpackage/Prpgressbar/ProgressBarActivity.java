package ir.khorrami.learningpackage.Prpgressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import ir.khorrami.learningpackage.R;

public class ProgressBarActivity extends AppCompatActivity {
    SeekBar seekBar;
    private int progressPreValue = 0;
    private boolean increasing = false;
    private boolean userDragging = true;
    private boolean progressEffect = false;
    TextView txtvals, txtIncrese, txtBackText, txtIsExit, txtIsEnter;
    Button btnSave;
    boolean userIsEnter = true;
    boolean userIsExit = false;
    final int SEEK_MIN_VALUE = 9;
    final int SEEK_MAX_VALUE = 91;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        seekBar = findViewById(R.id.seekBar_luminosite);
        txtvals = findViewById(R.id.txtValue);
        txtIncrese = findViewById(R.id.txtIncrese);
        btnSave = findViewById(R.id.btnClear);
        txtBackText = findViewById(R.id.txtBack);
        txtIsEnter = findViewById(R.id.txtUserIsEnter);
        txtIsExit = findViewById(R.id.txtUserIsExit);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            seekBar.setProgress(SEEK_MAX_VALUE, true);
        } else
            seekBar.setProgress(SEEK_MAX_VALUE);

        userIsEnter = false;
        userIsExit = true;

        SeekBar.OnSeekBarChangeListener changeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                if (progressValue <= SEEK_MIN_VALUE) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        seekBar.setProgress(SEEK_MIN_VALUE, true);
                    } else
                        seekBar.setProgress(SEEK_MIN_VALUE);

                    return;

                }

                if (progressValue > SEEK_MAX_VALUE) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        seekBar.setProgress(SEEK_MAX_VALUE, true);
                    } else
                        seekBar.setProgress(SEEK_MAX_VALUE);

                    return;

                }

                userDragging = fromUser;
                if (fromUser) {
                    txtBackText.setVisibility(View.GONE);
                    increasing = (progressValue - progressPreValue) >= 0;
                    txtvals.setText("Prevalue : " + String.valueOf(progressPreValue) + "value : " + String.valueOf(progressValue));
                    progressPreValue = progressValue;
                    txtIncrese.setText(increasing ? "True" : "False");

//                    if (progressValue < 40) {
//                        txtBackText.setText("خروج");
//                        txtBackText.setLeft(5);
//                        txtBackText.setVisibility(View.VISIBLE);
//                        userIsEnter = true;
//
//                    } else if (progressValue > 60) {
//                        txtBackText.setText("ورود");
//                        txtBackText.setLeft(100);
//                        txtBackText.setVisibility(View.VISIBLE);

                }

                if (increasing) {
                    if (progressValue >= 60 && !userIsExit) {
                        userIsEnter = false;
                        userIsExit = true;
                        seekBar.setEnabled(false);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            seekBar.setProgress(SEEK_MAX_VALUE, true);
                        } else
                            seekBar.setProgress(SEEK_MAX_VALUE);

                        Toast.makeText(getApplicationContext(), "Ready for ENTER", Toast.LENGTH_SHORT).show();
                        progressPreValue = SEEK_MAX_VALUE;
//                            txtBackText.setText("خروج");
//                            txtBackText.setVisibility(View.VISIBLE);
                    }
                }

                if (!increasing) {
                    if (progressValue <= 40 && !userIsEnter) {
                        userIsEnter = true;
                        userIsExit = false;
                        seekBar.setEnabled(false);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            seekBar.setProgress(SEEK_MIN_VALUE, true);
                        } else
                            seekBar.setProgress(SEEK_MIN_VALUE);

                        Toast.makeText(getApplicationContext(), "Ready for EXIT", Toast.LENGTH_SHORT).show();
                        progressPreValue = SEEK_MIN_VALUE;
                        txtBackText.setText("ورود");
                        txtBackText.setVisibility(View.VISIBLE);
                    }
                }
//                    seekBar.setThumb(getThumb(progress));
                txtIsEnter.setText("IsEnter : " + (userIsEnter ? "True" : "False"));
                txtIsExit.setText("IsExit   : " + (userIsExit ? "True" : "False"));
            }

//                onClick2();
//                seekBar.setEnabled(true);
            //seekBar.setOnSeekBarChangeListener(this);


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                if (seekBar.getProgress() > 30 && seekBar.getProgress() < 70)
                if (increasing) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        seekBar.setProgress(SEEK_MIN_VALUE, true);
                    } else
                        seekBar.setProgress(SEEK_MIN_VALUE);

                } else if (!increasing) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        seekBar.setProgress(SEEK_MAX_VALUE, true);
                    } else
                        seekBar.setProgress(SEEK_MAX_VALUE);


                }
                seekBar.setEnabled(true);
                progressPreValue = seekBar.getProgress();
//                txtvals.setText("Prevalue : " + String.valueOf(progressPreValue) + "value : " + String.valueOf(seekBar.getProgress()));

            }
        };


        seekBar.setOnSeekBarChangeListener(changeListener);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBar.setEnabled(true);
//                seekBar.setOnSeekBarChangeListener(changeListener);
//                progressPreValue=0;
            }
        });


    }
//    public Drawable getThumb(int progress) {
//        ((TextView) thumbView.findViewById(R.id.seekBar_luminosite)).setText(progress + "");
//
//        thumbView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
//        Bitmap bitmap = Bitmap.createBitmap(thumbView.getMeasuredWidth(), thumbView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        thumbView.layout(0, 0, thumbView.getMeasuredWidth(), thumbView.getMeasuredHeight());
//        thumbView.draw(canvas);
//
//        return new BitmapDrawable(getResources(), bitmap);
//    }
}