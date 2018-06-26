package greendaotest.wq.com.demo.activity;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import greendaotest.wq.com.demo.R;
import greendaotest.wq.com.demo.utils.ScreenSwitchUtils;

public class SensorActivity extends AppCompatActivity implements ScreenSwitchUtils.OnScreenChangedListener {

    private ScreenSwitchUtils instance;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        instance = ScreenSwitchUtils.init(this.getApplicationContext());
        instance.setOnScreenChangedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        instance.start(this);
    }

    private static final String TAG = "SensorActivity";

    @Override
    protected void onStop() {
        super.onStop();
        instance.stop();
    }

    @Override
    public void screenChangedListener(boolean isPotrait) {
        Toast.makeText(this,"" + isPotrait, Toast.LENGTH_SHORT).show();
        try {
            int screenchange = Settings.System.getInt(getContentResolver(), Settings.System.ACCELEROMETER_ROTATION);
            Log.i(TAG, "screenChangedListener: " + screenchange);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }
}
