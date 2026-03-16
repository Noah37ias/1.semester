package opg1;

import java.util.ArrayList;

public class Swimmer {
    private String name;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;

    public Swimmer(String name, ArrayList<Double> lapTimes) {
        this.name = name;
        this.lapTimes = lapTimes;

    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    /**
     * Return the fastest lap time.
     * Pre: The swimmer has at least one lap time.
     */
    public double bestLapTime() {
        // TODO
        double best = 10;
        for(double lapTime : lapTimes) {
            if(lapTime < best) {
                best = lapTime;
            }
        }
        return best;
    }

    public int allTrainHours() {
        if(trainingPlan != null) {
            return trainingPlan.getWeeklyWaterHours() + trainingPlan.getWeeklyStrengthHours();
        }
        return 0;
    }
}
