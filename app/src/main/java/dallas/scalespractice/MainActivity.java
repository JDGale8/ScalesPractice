package dallas.scalespractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String KEY_SCALE = "KEY_SCALE";
    private TextView mScaleText;
    private TextView mMajMinText;
    private ImageButton mSettingsBtn;
    private Button mScaleBtn;
    private MajorScalesPractice mMajorScales = new MajorScalesPractice();
    private RadioGroup mScaleTypeRadio;
    private RadioGroup mMajMinRadio;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScaleBtn =  (Button) findViewById(R.id.newScaleBtn);
        mSettingsBtn = (ImageButton) findViewById(R.id.settingsButton);
        mScaleText = (TextView) findViewById(R.id.scaleText);
        mMajMinText = (TextView) findViewById(R.id.majorMinorText);
        mScaleTypeRadio = (RadioGroup) findViewById(R.id.scaleRadioGroup);
        mMajMinRadio = (RadioGroup) findViewById(R.id.majMinRadioGroup);


        // Animations
        //Animation pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);


        View.OnClickListener newScaleListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when the button is clicked, it needs to update mScaleText with a new scale
                String scale = "";
                //randomly select either a natural or accidental scale depending on the radio button
                scale = "";

                int selMajMin = mMajMinRadio.getCheckedRadioButtonId();

                int majScaleId = 2131492951;
                int minScaleId = 2131492952;
                int bothScaleId = 2131492953;

                int selScaleType = mScaleTypeRadio.getCheckedRadioButtonId();

                Log.d(TAG, "int value of maj/min radio button is:" +selScaleType);

                int naturalScaleId = 2131492949;
                int allScaleId = 2131492950;

                //if / else statement depending on if our choice is major or minor
                if(selMajMin==majScaleId) {
                    mMajMinText.setText("Major");
                    if (selScaleType == naturalScaleId) {
                        scale = MajorScalesPractice.getSimpleMScale();
                    } else if (selScaleType == allScaleId) {
                        scale = MajorScalesPractice.getFullMScale();
                    }

                    //update the scale
                    mScaleText.setText(scale);
                }
                else if(selMajMin==minScaleId) {
                    mMajMinText.setText("Minor");
                    if (selScaleType == naturalScaleId) {
                        scale = MajorScalesPractice.getSimpleMScale();
                    } else if (selScaleType == allScaleId) {
                        scale = MajorScalesPractice.getFullMScale();
                    }

                    //update the scale
                    mScaleText.setText(scale);
                }



                else if(selMajMin==bothScaleId) {
                    Random randomGenerator = new Random();
                    int randomInt = randomGenerator.nextInt(2);
                    if (randomInt==0) {
                        mMajMinText.setText("Major");
                    }
                    if (randomInt==1) {
                        mMajMinText.setText("Minor");
                    }
                    if (selScaleType == naturalScaleId) {
                        scale = MajorScalesPractice.getSimpleMScale();
                    } else if (selScaleType == allScaleId) {
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
            }

        };

        mSettingsBtn.setOnClickListener(settingsListener);

        mScaleBtn.setOnClickListener(newScaleListener);
    }
}
