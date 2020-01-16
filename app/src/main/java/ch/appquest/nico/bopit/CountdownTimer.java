package ch.appquest.nico.bopit;

import android.os.AsyncTask;
import android.os.CountDownTimer;

final class CountdownTimer extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
        try {
            //Timer for commands
            CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {
                public void onTick(long millisUntilFinished) {
                    /*Command command = game.chooseCommand();
                    commandView.setText(command.getName());

                    isValid = game.checkIfValid();*/
                }

                public void onFinish() {
                    /*if (isValid) {
                        System.out.println("valid");
                        game.addScore();
                        scoreView.setText(String.valueOf(game.getScore()));
                        game.increaseSpeed();
                        System.out.println(game.getGameSpeed());
                    } else {
                        game.endGame();
                        inProgress[0] = false;
                    }*/
                }
            };

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // We were cancelled; stop sleeping!
        }
        return "Executed";
    }

    @Override
    protected void onPostExecute(String result) {

    }
}
