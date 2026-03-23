package rollTwoDice;

import java.util.Arrays;

public class Player {
    private Die die1;
    private Die die2;
    private int rollCount;
    int totalSameEyes = 0;
    int highestThrow = 0;
    int totalSum = 0;
    double gennnemsnit = 0;
    int[] counter = new int[7];

    public Player() {
        this.die1 = new Die();
        this.die2 = new Die();
    }

    public int getRollCount() {
        return rollCount;
    }

    public void throwDie() {
        die1.roll();
        die2.roll();
        rollCount++;
        rollCount++;
    }

    public int getTotalFacevalue() {
        return die1.getFaceValue() + die2.getFaceValue();
    }

    public int sameEyes() {
        if (die1.getFaceValue() == die2.getFaceValue()) {
            totalSameEyes++;
        }
        return totalSameEyes;
    }

    public int totalSum() {
        totalSum = getTotalFacevalue() + totalSum;
        return totalSum;
    }

    public int highestSum() {
        if (getTotalFacevalue() > highestThrow) {
            highestThrow = getTotalFacevalue();
        }
        return highestThrow;
    }

    public int[] valueAndThrow() {
        for (int i = 0; i < counter.length; i++) {
            if (i == die1.getFaceValue()) {
                counter[i] += 1;
            }
            if (i == die2.getFaceValue()) {
                counter[i] += 1;
            }
        }
        return counter;
    }

    public double averageThrow() {
        gennnemsnit = (double) totalSum() / getRollCount();//Vi skriver double for at undgå afrunding
        return gennnemsnit;
    }

    public void play() {
        IO.println("Roll?");
        IO.readln();

        boolean finished = false;
        while (!finished) {
            throwDie();
            IO.println("Rolling...");
            IO.println(die1.getFaceValue() + ", " + die2.getFaceValue() + " The total is: " + getTotalFacevalue());
            IO.println("Times with the same eyes: " + sameEyes());
            IO.println("Highest throw: " + highestSum());
            IO.println("Roll again? (y/n)");
            String again = IO.readln();
            if (again.equalsIgnoreCase("n")) {
                finished = true;
            }
            IO.println(totalSum());
            IO.println(averageThrow());
            valueAndThrow();
            for (int i = 1; i <= 6; i++) {
                IO.println(String.format("Value: %d, count: %d", i, counter[i]));
            }

        }
    }
}