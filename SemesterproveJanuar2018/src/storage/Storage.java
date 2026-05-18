package storage;

import model.*;

import java.util.ArrayList;

public abstract class Storage {
    private static ArrayList<Uddannelse> uddannelser = new ArrayList<>();
    private static ArrayList<Tutor> tutors = new ArrayList<>();
    private static ArrayList<Arrangement> arrangements = new ArrayList<>();

    public static void storeUddannelse(Uddannelse uddannelse) {
        uddannelser.add(uddannelse);
    }
    public static void storeTutor(Tutor tutor) {
        tutors.add(tutor);
    }
    public static void storeArrangement(Arrangement arrangement) {
        arrangements.add(arrangement);
    }

    public static ArrayList<Uddannelse> getUddannelser() {
        return uddannelser;
    }

    public static ArrayList<Tutor> getTutors() {
        return tutors;
    }

    public static ArrayList<Arrangement> getArrangements() {
        return arrangements;
    }
}
