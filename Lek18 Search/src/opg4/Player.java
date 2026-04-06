package opg4;

import java.util.ArrayList;

public class Player {
    String name;
    int scoredGoals;
    int height;
    int weight;

    public Player(String name, int scoredGoals, int height, int weight) {
        this.name = name;
        this.scoredGoals = scoredGoals;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ScoredGoals: " + scoredGoals + ", Height: " + height + ", Weight: " + weight;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }


}
