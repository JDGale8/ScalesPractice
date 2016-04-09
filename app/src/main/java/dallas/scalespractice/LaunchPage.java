package dallas.scalespractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Vibrator;

public class LaunchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_page);

        final Vibrator vibr = (Vibrator)getSystemService(this.VIBRATOR_SERVICE);

        final ImageButton loadRandomBtn = (ImageButton) findViewById(R.id.practiceBtn);
        final ImageButton loadScalesBtn = (ImageButton) findViewById(R.id.learnBtn);

        loadRandomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent("dallas.scalespractice.MainActivity");
                startActivity(mainIntent);
                vibr.vibrate(28);
            }
        });

        /*
        loadScalesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent("dallas.tsa_randomizerisajoke.MainActivity");
                startActivity(mainIntent);
            }
        });
        */

    }

}
