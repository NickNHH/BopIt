package ch.appquest.nico.bopit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SingleplayerActivity extends AppCompatActivity {
    TextView commandView;
    TextView scoreView;

    Commands commands;
    Game game;
    boolean isValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
        game = new Game();

        commandView = findViewById(R.id.commandText);
        scoreView = findViewById(R.id.score);

        commands = new Commands();
        commands.setCommands();

        startGameLoop();
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
        for (int i = 0; i < 20; i++) {
            Command command = game.chooseCommand();
            commandView.setText(command.getName());

            isValid = game.checkIfValid(command);

            if (isValid) {
                System.out.println("valid");
                game.addScore(command.getPoints());
                scoreView.setText(String.valueOf(game.getScore()));
                game.increaseSpeed();
                System.out.println(game.getGameSpeed());
            } else {
                game.endGame();
                inProgress[0] = false;
            }
        }
    }
}
