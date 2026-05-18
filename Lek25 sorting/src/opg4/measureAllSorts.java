package opg4;

import java.util.ArrayList;
import java.util.Random;

public class measureAllSorts {
    void main() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        Random random = new Random();
        list1.addAll(random.ints(50000, 1, 1000).boxed().toList());
        list2.addAll(random.ints(50000, 1, 1000).boxed().toList());
        list3.addAll(random.ints(50000, 1, 1000).boxed().toList());
        System.currentTimeMillis();
        long startTimeBubble = System.currentTimeMillis();
        bubbleSort(list1);
        long endTimeBubble = System.currentTimeMillis();
        IO.println("Tid for BubbleSort: " + (endTimeBubble - startTimeBubble) + " ms");
        long startTimeSelection = System.currentTimeMillis();
        selectionSort(list2);
        long endTimeSelection = System.currentTimeMillis();
        IO.println("Tid for SelectionSort: " + (endTimeSelection - startTimeSelection) + " ms");
        long startTimeInsertion = System.currentTimeMillis();
        insertionSort(list3);
        long endTimeInsertion = System.currentTimeMillis();
        IO.println("Tid for InsertionSort: " + (endTimeInsertion - startTimeInsertion) + " ms");
    }

    public static void bubbleSort(ArrayList<Integer> liste) {
        boolean swapped = true;
        for (int i = liste.size() - 1; swapped && i > 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (liste.get(j) > liste.get(j + 1)) {
                    int temp = liste.get(j);
                    liste.set(j, liste.get(j + 1));
                    liste.set(j + 1, temp);
                    swapped = true;
                }
            }
        }
    }

    public static void selectionSort(ArrayList<Integer> liste) {
        for (int i = 0; i < liste.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < liste.size(); j++) {
                if (liste.get(j) < liste.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = liste.get(i);
            liste.set(i, liste.get(minIndex));
            liste.set(minIndex, temp);
        }
    }

    public static void insertionSort(ArrayList<Integer> liste) {
        for (int i = 1; i < liste.size(); i++) {
            int temp = liste.get(i);
            int j = i - 1;
            while (j >= 0 && liste.get(j) > temp) {
                liste.set(j + 1, liste.get(j));
                j--;
            }
            liste.set(j + 1, temp);
        }
    }


    public static void bubbleSort1(ArrayList<Integer> liste) {
        // Holder styr på, om vi har lavet en ombytning i den nuværende gennemgang.
        boolean swapped = true;

        // Ydre løkke: Kører fra bagenden og fremad.
        // Den stopper tidligt, hvis 'swapped' er false (hvilket betyder, at listen er færdigsorteret).
        for (int i = liste.size() - 1; swapped && i > 0; i--) {
            // Vi nulstiller swapped før vi går i gang med at tjekke naboer.
            swapped = false;

            // Indre løkke: Gennemgår listen fra starten og op til det område, der allerede ER sorteret (i).
            for (int j = 0; j < i; j++) {

                // Hvis det nuværende tal er større end dets nabo til højre...
                if (liste.get(j) > liste.get(j + 1)) {

                    // ... så bytter vi rundt på dem (Swap):
                    int temp = liste.get(j);                // Gemmer det store tal midlertidigt.
                    liste.set(j, liste.get(j + 1));         // Sætter det mindre nabo-tal ind på den nuværende plads.
                    liste.set(j + 1, temp);                 // Sætter det store tal ind på naboens plads.

                    // Vi registrerer, at vi har lavet et bytte, så algoritmen ved, at den skal køre mindst én gang til.
                    swapped = true;
                }
            }
        }
    }

    public static void selectionSort1(ArrayList<Integer> liste) {
        // Ydre løkke: Gennemgår hver plads i listen (undtagen den allersidste, for når vi når dertil, er resten på plads).
        for (int i = 0; i < liste.size() - 1; i++) {

            // Vi antager i starten, at det mindste tal findes på vores nuværende startplads 'i'.
            int minIndex = i;

            // Indre løkke: Leder gennem resten af listen (fra pladsen LIGE EFTER 'i') for at finde et tal, der er endnu mindre.
            for (int j = i + 1; j < liste.size(); j++) {

                // Hvis vi finder et tal, der er mindre end vores hidtil mindste tal...
                if (liste.get(j) < liste.get(minIndex)) {
                    // ... så gemmer vi dette nye tals placering (indeks) som det nye minimum.
                    minIndex = j;
                }
            }

            // Når den indre løkke er færdig, har vi fundet den sande placering for det mindste tal.
            // Nu bytter vi (Swap):
            int temp = liste.get(i);                // Gemmer tallet fra vores startplads 'i' midlertidigt.
            liste.set(i, liste.get(minIndex));      // Sætter det fundne mindste tal ind på startpladsen.
            liste.set(minIndex, temp);              // Sætter det oprindelige start-tal ud på den plads, hvor det mindste tal lå.
        }
    }

    public static void insertionSort1(ArrayList<Integer> liste) {
        // Ydre løkke: Vi starter ved element nr. 2 (indeks 1).
        // Vi antager, at det første element (indeks 0) allerede udgør en "sorteret liste" i sig selv.
        for (int i = 1; i < liste.size(); i++) {

            // Gemmer det tal, vi er nået til i denne runde. Det er dette tal, der skal indsættes på sin rigtige plads.
            int temp = liste.get(i);

            // 'j' peger på elementet lige foran 'temp'. Det er herfra, vi begynder at kigge baglæns (mod venstre).
            int j = i - 1;

            // (While): Så længe vi ikke er nået helt tilbage forbi starten (j >= 0)
            // OG tallet på plads 'j' er større end vores 'temp'-tal...
            while (j >= 0 && liste.get(j) > temp) {

                // ... så rykker vi det større tal én plads til højre for at gøre plads til 'temp'.
                liste.set(j + 1, liste.get(j));

                // Rykker vores "kigge-punkt" 'j' én plads længere til venstre for at tjekke næste tal.
                j--;
            }

            // Når while-løkken stopper (enten fordi vi ramte bunden, eller fordi tallet på plads 'j' er mindre end 'temp'),
            // sætter vi vores 'temp'-tal ind på den tomme plads lige til højre for 'j'.
            liste.set(j + 1, temp);
        }
    }
}
