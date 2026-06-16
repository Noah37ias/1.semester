package storage;

import model.*;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Hold> holdene = new ArrayList<>();
    private static final ArrayList<Badge> badges = new ArrayList<>();

    public static void storeHold(Hold hold){
        holdene.add(hold);
    }
    public static void storeBadges(Badge badge){
        badges.add(badge);
    }

    public static ArrayList<Hold> getHoldene(){
        return holdene;
    }
    public static ArrayList<Badge> getBadges(){
        return badges;
    }
}
