package dallas.scalespractice;
import android.util.Log;

import java.util.Random;

/**
 * Created by Jake on 4/9/2016.
 * This will renadomly select a major scale, with a method for natural and accidental scales.
 */
public class MajorScalesPractice {

    private static final String TAG = MajorScalesPractice.class.getSimpleName();

    public static String[] mSimpleMScales = {"A","B","C","D","E","F","G"};
    public static String[] mFullMScales = {"Ab","A","Bb","B","C","C#","D","Eb","E","F","F#","G"};

    public static String mScale;



    public static String getSimpleMScale(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(mSimpleMScales.length);
        mScale = mSimpleMScales[randomInt];

        Log.d(TAG, "Simple Scale returned is: " + mScale);

        return mScale;
    }

    public static String getFullMScale(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(mFullMScales.length);
        mScale = mFullMScales[randomInt];

        Log.d(TAG, "Full Scale returned is: " + mScale);

        return mScale;
    }
}
