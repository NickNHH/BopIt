package ch.appquest.nico.bopit;

import android.hardware.SensorEvent;
import android.os.Handler;

import java.util.Arrays;

class Validate {
    private boolean isValid = false;
    private int gameSpeed;
    private long lastUpdate = 0L;
    private float last_x = 0f;
    private float last_y = 0f;
    private float last_z = 0f;

    Validate(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    boolean bop() {
        return true;
    }

    boolean swipe() {
        return true;
    }

    boolean spin() {
        return true;
    }

    boolean flip(SensorEvent event) {
        boolean isValid = false;
        System.out.println(Arrays.toString(event.values));

        float z_value = event.values[2];
        if (z_value >= 0) {
            isValid = true;
        }
        return isValid;
    }

    boolean shake(final SensorEvent event) {
        isValid = false;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                long curTime = System.currentTimeMillis();
                float speed = 0;

                if ((curTime - lastUpdate) > 100) {
                    long diffTime = (curTime - lastUpdate);
                    lastUpdate = curTime;

                    Float x = event.values[0];
                    Float y = event.values[1];
                    Float z = event.values[2];
                    //speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;
                    speed = 801;

                    last_x = x;
                    last_y = y;
                    last_z = z;
                }

                if (speed > 800) {
                    isValid = true;
                }
            }
        }, 1000);
        System.out.println(isValid);
        return isValid;
    }

    boolean leave() {
        return true;
    }

    private void makeValidTrue() {
        isValid = true;
    }
}
