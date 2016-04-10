package dallas.scalespractice;

        import android.app.Activity;
        import android.graphics.drawable.ColorDrawable;
        import android.os.Bundle;
        import android.util.DisplayMetrics;
        import android.view.Gravity;
        import android.view.View;
        import android.view.WindowManager;

public class RandomSettings extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_settings);

        // We need to calculate the screen size and change the popup window accordingly

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        // sets the window to 80% of the phone/tablet screen
        getWindow().setLayout((int)(width*0.5),(int)(height*0.9));

    }
}