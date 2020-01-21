package ch.appquest.nico.bopit;

import java.util.Random;

class Game {
    private Commands commands = new Commands();
    private Validate validate = new Validate();
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
        boolean isValid;

        switch (command.getName().toLowerCase().trim()) {
            case "bop it!":
                isValid = validate.bop();
                break;
            case "swipe it!":
                isValid = validate.swipe();
                break;
            case "spin it!":
                isValid = validate.spin();
                break;
            case "flip it!":
                isValid = validate.flip();
                break;
            case "shake it!":
                isValid = validate.shake();
                break;
            case "leave it!":
                isValid = validate.leave();
                break;
            default:
                isValid = false;
        }
        return isValid;
    }

    void addScore(int points) {
        score += points;
    }

    int getScore() {
        return score;
    }

    void endGame() {
        //TODO: Switch activity
    }
}
