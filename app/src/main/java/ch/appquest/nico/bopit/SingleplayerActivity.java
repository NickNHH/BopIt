package ch.appquest.nico.bopit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class SingleplayerActivity extends AppCompatActivity {
    Commands commands;
    Game game = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        commands = new Commands();
        commands.setCommands();
    }

    public void bopItClicked(View view) {
        Command command = game.chooseCommand();
        System.out.println(command.getName());
    }
}
