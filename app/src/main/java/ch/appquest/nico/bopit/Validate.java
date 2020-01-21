package ch.appquest.nico.bopit;

class Validate {
    private int gameSpeed;

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

    boolean flip() {
        return true;
    }

    boolean shake() {
        return true;
    }

    boolean leave() {
        return true;
    }

    private void pause() {
        try {
            Thread.sleep(gameSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
