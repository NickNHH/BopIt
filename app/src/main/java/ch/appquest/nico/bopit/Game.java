package ch.appquest.nico.bopit;

import java.util.Random;

class Game {
    private Commands commands = new Commands();

    void gameLoop() {

    }

    Command chooseCommand() {
        commands.setCommands();
        Random random = new Random();
        int number = random.nextInt(commands.getCommands().size());

        return commands.getCommands().get(number);
    }

    void increaseSpeed() {

    }

    void checkIfValid() {

    }

    void addScore() {

    }

    void endGame() {

    }
}
