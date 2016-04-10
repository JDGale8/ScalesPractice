package dallas.scalespractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Vibrator;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String KEY_SCALE = "KEY_SCALE";
    private TextView mScaleText;
    private TextView mMajMinText;
    private ImageButton mSettingsBtn;
    private Button mScaleBtn;
    private RadioButton mAllScaleRadio;
    private RadioButton mNaturalScaleRadio;
    private RadioButton mMinorScaleRadio;
    private RadioButton mMajorScaleRadio;
    private RadioButton mBothMinMajScaleRadio;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Vibrator vibr = (Vibrator)getSystemService(this.VIBRATOR_SERVICE);

        mScaleBtn =  (Button) findViewById(R.id.newScaleBtn);
        mSettingsBtn = (ImageButton) findViewById(R.id.settingsButton);
        mScaleText = (TextView) findViewById(R.id.scaleText);
        mMajMinText = (TextView) findViewById(R.id.majorMinorText);
        mAllScaleRadio = (RadioButton) findViewById(R.id.allScaleRadio);
        mNaturalScaleRadio = (RadioButton) findViewById(R.id.naturalScaleRadio);
        mMinorScaleRadio = (RadioButton) findViewById(R.id.minorScaleRadio);
        mMajorScaleRadio = (RadioButton) findViewById(R.id.majorScaleRadio);
        mBothMinMajScaleRadio = (RadioButton) findViewById(R.id.bothMinMajScaleRadio);

        View.OnClickListener newScaleListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when the button is clicked, it needs to update mScaleText with a new scale
                String scale = "";
                //randomly select either a natural or accidental scale depending on the radio button

                //if / else statement depending on if our choice is major or minor
                if(mMajorScaleRadio.isChecked()) {
                    mMajMinText.setText("Major");
                    if (mNaturalScaleRadio.isChecked()) {
                        scale = MajorScalesPractice.getSimpleMScale();
                    } else if (mAllScaleRadio.isChecked()) {
                        scale = MajorScalesPractice.getFullMScale();
                    }

                    //update the scale
                    mScaleText.setText(scale);
                }
                else if(mMinorScaleRadio.isChecked()) {
                    mMajMinText.setText("Minor");
                    if (mNaturalScaleRadio.isChecked()) {
                        scale = MajorScalesPractice.getSimpleMScale();
                    } else if (mAllScaleRadio.isChecked()) {
                        scale = MajorScalesPractice.getFullMScale();
                    }

                    //update the scale
                    mScaleText.setText(scale);
                }



                else if(mBothMinMajScaleRadio.isChecked()) {
                    Random randomGenerator = new Random();
                    int randomInt = randomGenerator.nextInt(2);
                    if (randomInt==0) {
                        mMajMinText.setText("Major");
                    }
                    if (randomInt==1) {
                        mMajMinText.setText("Minor");
                    }
                    if (mNaturalScaleRadio.isChecked()) {
                        scale = MajorScalesPractice.getSimpleMScale();
                    } else if (mAllScaleRadio.isChecked()) {
                        scale = MajorScalesPractice.getFullMScale();
                    }

                    //update the scale
                    mScaleText.setText(scale);
                }
            }
        };

        View.OnClickListener settingsListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mSettingsBtn.startAnimation(buttonClick);
                vibr.vibrate(28);
                startActivity(new Intent(MainActivity.this, RandomSettings.class));

            }

        };

        mSettingsBtn.setOnClickListener(settingsListener);

        mScaleBtn.setOnClickListener(newScaleListener);
    }
}
