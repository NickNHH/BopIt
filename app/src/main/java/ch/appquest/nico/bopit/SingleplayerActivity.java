package ch.appquest.nico.bopit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class SingleplayerActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    SensorEvent currentEvent;

    TextView commandView;
    TextView scoreView;

    Commands commands;
    Command currentCommand;
    Game game;
    boolean isValid = false;
    private long countdown;
    private long lastUpdate = 0L;
    private float last_x = 0f;
    private float last_y = 0f;
    private float last_z = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
        game = new Game();

        commandView = findViewById(R.id.commandText);
        scoreView = findViewById(R.id.score);

        commands = new Commands();
        commands.setCommands();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        assert sensorManager != null;
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                countdown = System.currentTimeMillis();
            }
        }, 1000);

        startGameLoop();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                Float x = event.values[0];
                Float y = event.values[1];
                Float z = event.values[2];
                //float speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;
                float speed = 801;

                if (speed > 800) {
                    long value = curTime - countdown;
                    if (value < 1000) {
                        sensorManager.unregisterListener(this);
                        System.out.println("yes");
                    } else if (value > 1000) {
                        sensorManager.unregisterListener(this);
                        System.out.println("no");
                    }
                }
                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Empty method
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Set SensorManager to listen for the magnetic field sensor
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Deactivate sensors to prevent drain of battery when not used
        sensorManager.unregisterListener(this);
    }


    public void bopItClicked(View view) {
        Command command = game.chooseCommand();
        System.out.println(command.getName());
    }

    private void startGameLoop() {
        final boolean[] inProgress = {true};

        //Timer for commands
        /*CountDownTimer countDownTimer = new CountDownTimer(game.getGameSpeed(), 1000) {
            public void onTick(long millisUntilFinished) {
                Command command = game.chooseCommand();
                commandView.setText(command.getName());

                isValid = game.checkIfValid();
            }

            public void onFinish() {
                if (isValid) {
                    System.out.println("valid");
                    game.addScore();
                    scoreView.setText(String.valueOf(game.getScore()));
                    game.increaseSpeed();
                    System.out.println(game.getGameSpeed());
                } else {
                    game.endGame();
                    inProgress[0] = false;
                }
            }
        };*/

        //while (inProgress[0]) {
        //for (int i = 0; i < 20; i++) {
        currentCommand = game.chooseCommand();
        commandView.setText(currentCommand.getName());

        //while (!isValid) {
            //isValid = game.checkIfValid(currentCommand, currentEvent);
            if (isValid) {
                System.out.println("valid");
                game.addScore(currentCommand.getPoints());
                scoreView.setText(String.valueOf(game.getScore()));
                game.increaseSpeed();
                System.out.println(game.getGameSpeed());
            } else {
                game.endGame();
                inProgress[0] = false;
            }
        //}
        //}
    }
}
