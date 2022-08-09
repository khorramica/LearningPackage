package ir.khorrami.learningpackage.Prpgressbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import ir.khorrami.learningpackage.R;

public class ProgressBarActivity2 extends AppCompatActivity {
    SeekBar seekBar;
    private int progressPreValue = 0;
    private boolean increasing = false;
    TextView txtvals, txtIncrese, txtBackText, txtIsExit, txtIsEnter;
    Button btnSave;

    boolean userInEnterMode = true;
    boolean userInExitMode = false;
    final int SEEK_MIN_VALUE = 9;
    final int SEEK_MAX_VALUE = 91;
    final int EXIT_POINT = 30;
    final int ENTER_POINT = 70;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar2);
        seekBar = findViewById(R.id.seekBar_luminosite);
        txtvals = findViewById(R.id.txtValue);
        txtIncrese = findViewById(R.id.txtIncrese);
        btnSave = findViewById(R.id.btnClear);
        //txtBackText = findViewById(R.id.txt);
        txtIsEnter = findViewById(R.id.txtUserIsEnter);
        txtIsExit = findViewById(R.id.txtUserIsExit);

        seekBar.setProgress(SEEK_MIN_VALUE);
        userInEnterMode = false;
        userInExitMode = true;
        txtIsEnter.setText("In Enter Mode : " + (userInEnterMode ? "True" : "False"));
        txtIsExit.setText("In Exit  Mode : " + (userInExitMode ? "True" : "False"));

        SeekBar.OnSeekBarChangeListener changeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                increasing = (progressValue - progressPreValue) >= 0;
                if (progressValue <= SEEK_MIN_VALUE) {
                    seekBar.setProgress(SEEK_MIN_VALUE);
                    progressPreValue = SEEK_MIN_VALUE;
                    increasing = false;
                }

                if (progressValue >= SEEK_MAX_VALUE) {
                    seekBar.setProgress(SEEK_MAX_VALUE);
                    progressPreValue = SEEK_MAX_VALUE;
                    increasing = true;
                }

                if (fromUser) {
//                    txtBackText.setVisibility(View.GONE);
                    progressPreValue = progressValue;
                    txtIncrese.setText(increasing ? "Increasing : True" : "Increasing : False");
                    txtvals.setText("Prevalue : " + String.valueOf(progressPreValue) + "  -  value : " + String.valueOf(progressValue));

                }

                if (increasing) {
                    if (progressValue >= ENTER_POINT && userInExitMode) {
                        userInEnterMode = true;
                        userInExitMode = false;
                        seekBar.setEnabled(false);
                        seekBar.setProgress(SEEK_MAX_VALUE);
                        progressPreValue = SEEK_MAX_VALUE;
                        txtvals.setText("Prevalue : " + String.valueOf(progressPreValue) + "  -  value : " + String.valueOf(progressValue));
                        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                    }
                }

                if (!increasing) {
                    if (progressValue <= EXIT_POINT && userInEnterMode) {
                        userInEnterMode = false;
                        userInExitMode = true;
                        seekBar.setEnabled(false);
                        seekBar.setProgress(SEEK_MIN_VALUE);
                        progressPreValue = SEEK_MIN_VALUE;
                        txtvals.setText("Prevalue : " + String.valueOf(progressPreValue) + "  -  value : " + String.valueOf(progressValue));
                        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                    }
                }

                txtIsEnter.setText("In Enter Mode : " + (userInEnterMode ? "True" : "False"));
                txtIsExit.setText("In Exit  Mode : " + (userInExitMode ? "True" : "False"));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (increasing) {
                    seekBar.setProgress(SEEK_MIN_VALUE);

                } else if (!increasing) {
                    seekBar.setProgress(SEEK_MAX_VALUE);
                }

                seekBar.setEnabled(true);
                progressPreValue = seekBar.getProgress();
                txtvals.setText("Prevalue : " + String.valueOf(progressPreValue) + "  -  value : " + String.valueOf(seekBar.getProgress()));
            }
        };


        seekBar.setOnSeekBarChangeListener(changeListener);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBar.setEnabled(true);
                if (userInEnterMode) {
                    seekBar.setProgress(SEEK_MAX_VALUE);
                    progressPreValue = SEEK_MAX_VALUE;
                    increasing = true;
                } else if (userInExitMode) {
                    seekBar.setProgress(SEEK_MIN_VALUE);
                    progressPreValue = SEEK_MIN_VALUE;
                    increasing = false;
                }
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