package ch.appquest.nico.bopit;

public class Command {
    private String name;
    private String description;
    private int points;

    Command(String name, String description, int points) {
        this.name = name;
        this.description = description;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
