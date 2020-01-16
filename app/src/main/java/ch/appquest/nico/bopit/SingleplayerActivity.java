package ch.appquest.nico.bopit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class SingleplayerActivity extends AppCompatActivity {
    TextView commandView;
    TextView scoreView;

    Commands commands;
    Game game = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

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
        boolean inProgress = true;
        final boolean[] isValid = {true};
        while (inProgress) {
            Command command = game.chooseCommand();
            commandView.setText(command.getName());

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    // Actions to do after given seconds
                    isValid[0] = game.checkIfValid();
                }
            }, game.getGameSpeed());

            if (isValid[0]) {
                game.addScore();
                scoreView.setText(game.getScore());
                game.increaseSpeed();
            } else {
                game.endGame();
                inProgress = false;
            }
        }
    }
}
