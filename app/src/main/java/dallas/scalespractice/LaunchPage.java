package dallas.scalespractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LaunchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_page);

        final Button loadRandomBtn = (Button) findViewById(R.id.randomScalesActivityBtn);
        final Button loadScalesBtn = (Button) findViewById(R.id.scalePracticeActivityBtn);

        loadRandomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent("dallas.scalespractice.MainActivity");
                startActivity(mainIntent);
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
