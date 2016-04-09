package dallas.scalespractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String KEY_SCALE = "KEY_SCALE";
    private TextView mScaleText;
    private Button mScaleBtn;
    private MajorScalesPractice mMajorScales = new MajorScalesPractice();
    private RadioGroup mScaleTypeRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScaleBtn =  (Button) findViewById(R.id.newScaleBtn);
        mScaleText = (TextView) findViewById(R.id.scaleText);
        mScaleTypeRadio = (RadioGroup) findViewById(R.id.scaleRadioGroup);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when the button is clicked, it needs to update mScaleText with a new scale
                String scale = "";
                //randomly select either a natural or accidental scale depending on the radio button
                scale = "";

                Log.d(TAG, "int value of radio button is:" +scale);

                int selScaleType = mScaleTypeRadio.getCheckedRadioButtonId();

                int naturalScaleId = 2131492948;
                int allScaleId = 2131492949;

                if (selScaleType == naturalScaleId) {
                    scale = MajorScalesPractice.getSimpleMScale();
                }
                else if (selScaleType==allScaleId){
                    scale = MajorScalesPractice.getFullMScale();
                }

                //update the scale
                mScaleText.setText(scale);
            }
        };

        mScaleBtn.setOnClickListener(listener);
    }
}
