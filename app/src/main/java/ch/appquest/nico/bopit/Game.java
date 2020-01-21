package ch.appquest.nico.bopit;

import java.util.Random;

class Game {
    private Commands commands = new Commands();
    private int score = 0;
    private int gameDelay = 5000;

    Command chooseCommand() {
        commands.setCommands();
        Random random = new Random();
        int number = random.nextInt(commands.getCommands().size());

        return commands.getCommands().get(number);
    }

    void increaseSpeed() {
        if (gameDelay >= 400) {
            gameDelay -= 200;
        }
    }

    int getGameSpeed() {
        return gameDelay;
    }

    boolean checkIfValid(Command command) {
        switch (command.getName()) {

        }
        return true;
    }

    void addScore(int points) {
        score += points ;
    }

    int getScore() {
        return score;
    }

    void endGame() {
        //TODO: Switch activity
    }
}
