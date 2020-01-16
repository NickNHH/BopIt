package ch.appquest.nico.bopit;

import java.util.ArrayList;

class Commands {
    private ArrayList<Command> commands = new ArrayList<>();

    ArrayList<Command> getCommands() {
        return commands;
    }

    void setCommands() {
        Command bopIt = new Command("Bop It!", "Press Bop It! button", 10);
        Command swipeIt = new Command("Swipe It!", "Slide the Swipe It! button", 10);
        Command spinIt = new Command("Spin It!", "Spin your phone 360°", 20);
        Command flipIt = new Command("Flip It!", "Flip your phone over, so your screen faces downwards", 20);
        Command shakeIt = new Command("Shake It!", "Shake your phone", 20);
        Command leaveIt = new Command("Leave It!", "Leave your phone alone", 10);

        commands.add(bopIt);
        commands.add(swipeIt);
        commands.add(spinIt);
        commands.add(flipIt);
        commands.add(shakeIt);
        commands.add(leaveIt);
    }
}
