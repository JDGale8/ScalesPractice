package dallas.scalespractice;

import android.bluetooth.BluetoothClass;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_SCALE = "KEY_SCALE";
    private TextView mScaleText;
    private Button mScaleBtn;
    private MajorScalesPractice mMajorScales = new MajorScalesPractice();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScaleBtn =  (Button) findViewById(R.id.newScaleBtn);
        mScaleText = (TextView) findViewById(R.id.scaleText);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when the button is clicked, it needs to update mScaleText with a new scale
                String scale = "";
                //randomly select a scale
                scale = MajorScalesPractice.getSimpleMScale();

                //update the scale
                mScaleText.setText(scale);
            }
        };

        mScaleBtn.setOnClickListener(listener);
    }
}
