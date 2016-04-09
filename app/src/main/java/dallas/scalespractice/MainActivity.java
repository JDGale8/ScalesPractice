package dallas.scalespractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String KEY_SCALE = "KEY_SCALE";
    private TextView mScaleText;
    private TextView mMajMinText;
    private Button mScaleBtn;
    private MajorScalesPractice mMajorScales = new MajorScalesPractice();
    private RadioGroup mScaleTypeRadio;
    private RadioGroup mMajMinRadio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScaleBtn =  (Button) findViewById(R.id.newScaleBtn);
        mScaleText = (TextView) findViewById(R.id.scaleText);
        mMajMinText = (TextView) findViewById(R.id.majorMinorText);
        mScaleTypeRadio = (RadioGroup) findViewById(R.id.scaleRadioGroup);
        mMajMinRadio = (RadioGroup) findViewById(R.id.majMinRadioGroup);

        View.OnClickListener listener = new View.OnClickListener() {
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


                Log.d(TAG, "int value of maj/min radio button is:" +selMajMin);

                int selScaleType = mScaleTypeRadio.getCheckedRadioButtonId();

                int naturalScaleId = 2131492948;
                int allScaleId = 2131492949;

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

        mScaleBtn.setOnClickListener(listener);
    }
}
