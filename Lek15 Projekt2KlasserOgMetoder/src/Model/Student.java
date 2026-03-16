package Model;

import java.util.Arrays;

public class Student {
    private String name;
    private boolean active;
    private int[] grades;
    private char[] answers;

    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
        this.answers = new char[10];
    }

    @Override
    public String toString() {
        String s = "Inaktiv";
        if (active) {
            s="Aktiv";
        }
        return "Student(" + name + ", " + s + ", " + Arrays.toString(grades) + ")";
    }

    public char[] getAnswers() {
        return answers;
    }
    public void setAnswers(char[] answers) {
        this.answers = answers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int bestGrade() {
        int best = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > best) {
                best = grades[i];
            }
        }
        return best;
    }

    public int averageGrade() {
        int average = 0;
        for (int i = 0; i < grades.length; i++) {
            average += grades[i];
        }
        return average / grades.length;
    }
}
