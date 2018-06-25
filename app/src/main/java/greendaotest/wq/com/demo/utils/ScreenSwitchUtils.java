package greendaotest.wq.com.demo.utils;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 860617010 on 2018/6/11.
 */

public class ScreenSwitchUtils {
    private static final String TAG = ScreenSwitchUtils.class.getSimpleName();
    private volatile static ScreenSwitchUtils mInstance;
//    private Activity mActivity;
    // 是否是竖屏
    private boolean isPortrait = true;
    private SensorManager sm;
    private OrientationSensorListener listener;
    private Sensor sensor;
//    private SensorManager sm1;
//    private Sensor sensor1;
//    private OrientationSensorListener1 listener1;
    private static List<Integer> one = new ArrayList<>();
    private static List<Integer> two = new ArrayList<>();
    private static List<Integer> three = new ArrayList<>();
    private List<Integer> finaly = new ArrayList<>();

    /**
     * 返回ScreenSwitchUtils单例
     **/
    public static ScreenSwitchUtils init(Context context) {
        if (mInstance == null) {
            synchronized (ScreenSwitchUtils.class) {
                if (mInstance == null) {
                    mInstance = new ScreenSwitchUtils(context);
                }
            }
        }
        for (int i = 46; i < 135; i++) {
            one.add(i);
        }
        for (int i = 226; i < 315; i++) {
            two.add(i);
        }
        for (int i = 316; i < 360; i++) {
            three.add(i);
        }
        for (int i = 1; i < 45; i++) {
            three.add(i);
        }
        return mInstance;
    }

    private ScreenSwitchUtils(Context context) {
//        Log.d(TAG, init orientation listener.);
        // 注册重力感应器,监听屏幕旋转
        sm = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        listener = new OrientationSensorListener();
        // 根据 旋转之后/点击全屏之后 两者方向一致,激活sm.
//        sm1 = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
//        sensor1 = sm1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        listener1 = new OrientationSensorListener1();
    }

    /**
     * 开始监听
     */
    public void start(Activity activity) {
//        mActivity = activity;
        sm.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI);
    }

    /**
     * 停止监听
     */
    public void stop() {
        sm.unregisterListener(listener);
//        sm1.unregisterListener(listener1);
    }

//    /**
//     * 手动横竖屏切换方向
//     */
//    public void toggleScreen() {
//        sm.unregisterListener(listener);
//        sm1.registerListener(listener1, sensor1, SensorManager.SENSOR_DELAY_UI);
//        if (isPortrait) {
//            isPortrait = false;
//            // 切换成横屏
//            mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        } else {
//            isPortrait = true;
//            // 切换成竖屏
//            mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        }
//    }

    /**
     * 重力感应监听者
     */
    public class OrientationSensorListener implements SensorEventListener {
        private static final int _DATA_X = 0;
        private static final int _DATA_Y = 1;
        private static final int _DATA_Z = 2;
        public static final int ORIENTATION_UNKNOWN = -1;

        public void onAccuracyChanged(Sensor arg0, int arg1) {
        }

        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            int orientation = ORIENTATION_UNKNOWN;
            float X = -values[_DATA_X];
            float Y = -values[_DATA_Y];
            float Z = -values[_DATA_Z];
            float magnitude = X * X + Y * Y;
            // Don't trust the angle if the magnitude is small compared to the y
            // value
            if (magnitude * 4 >= Z * Z) {
                // 屏幕旋转时
                float OneEightyOverPi = 57.29577957855f;
                float angle = (float) Math.atan2(-Y, X) * OneEightyOverPi;
                orientation = 90 - (int) Math.round(angle);
                // normalize to 0 - 359 range
                while (orientation >= 360) {
                    orientation -= 360;
                }
                while (orientation < 0) {
                    orientation += 360;
                }
            }

            if (orientation > 45 && orientation < 135) {
                if (!finaly.contains(orientation)) {
                    finaly.clear();
                    finaly.addAll(one);
                    isPortrait = false;
                    Log.i(TAG, "onSensorChanged: " + isPortrait);
                    onScreenChangedListener.screenChangedListener(isPortrait);
                }
            } else if (orientation > 135 && orientation < 225) {
            } else if (orientation > 225 && orientation < 315) {
                if (!finaly.contains(orientation)) {
                    finaly.clear();
                    finaly.addAll(two);
                    isPortrait = false;
                    Log.i(TAG, "onSensorChanged: " + isPortrait);
                    onScreenChangedListener.screenChangedListener(isPortrait);
                }
            } else if ((orientation > 315 && orientation < 360) || (orientation > 0 && orientation < 45)) {
                if (!finaly.contains(orientation)) {
                    finaly.clear();
                    finaly.addAll(three);
                    isPortrait = true;
                    Log.i(TAG, "onSensorChanged: " + isPortrait);
                    onScreenChangedListener.screenChangedListener(isPortrait);
                }
            }
        }
    }

//    public class OrientationSensorListener1 implements SensorEventListener {
//        private static final int _DATA_X = 0;
//        private static final int _DATA_Y = 1;
//        private static final int _DATA_Z = 2;
//        public static final int ORIENTATION_UNKNOWN = -1;
//
//        public OrientationSensorListener1() {
//        }
//
//        public void onAccuracyChanged(Sensor arg0, int arg1) {
//        }
//
//        public void onSensorChanged(SensorEvent event) {
//            float[] values = event.values;
//            int orientation = ORIENTATION_UNKNOWN;
//            float X = -values[_DATA_X];
//            float Y = -values[_DATA_Y];
//            float Z = -values[_DATA_Z];
//            float magnitude = X * X + Y * Y;
//            // Don't trust the angle if the magnitude is small compared to the y
//            // value
//            if (magnitude * 4 >= Z * Z) {
//                // 屏幕旋转时
//                float OneEightyOverPi = 57.29577957855f;
//                float angle = (float) Math.atan2(-Y, X) * OneEightyOverPi;
//                orientation = 90 - (int) Math.round(angle);
//                // normalize to 0 - 359 range
//                while (orientation >= 360) {
//                    orientation -= 360;
//                }
//                while (orientation < 0) {
//                    orientation += 360;
//                }
//            }
//            if (orientation > 225 && orientation < 315) {// 检测到当前实际是横屏
//                if (!isPortrait) {
//                    sm.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI);
//                    sm1.unregisterListener(listener1);
//                }
//            } else if ((orientation > 315 && orientation < 360) || (orientation > 0 && orientation < 45)) {// 检测到当前实际是竖屏
//                if (isPortrait) {
//                    sm.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI);
//                    sm1.unregisterListener(listener1);
//                }
//            }
//        }
//    }

    private OnScreenChangedListener onScreenChangedListener;

    public void setOnScreenChangedListener(OnScreenChangedListener onScreenChangedListener) {
        this.onScreenChangedListener = onScreenChangedListener;
    }

    public interface OnScreenChangedListener {
        void screenChangedListener(boolean isPotrait);
    }
}
