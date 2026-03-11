package opg2;

import java.util.ArrayList;


public class ArrayListTest {
    void main() {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 67));//tal mellem 0 og 66 10 gange
        }
        for(Integer i : list) {
            IO.println(i);
        }

        IO.println("Som of list: " + sum(list));
        IO.println("Min in list: " + min(list));
        IO.println("Max in list: " + max(list));
        IO.println("Avg in list: " + average(list));
        IO.println("Zeroes in list: " + zeroes(list));
        IO.println("List with all the evens: " + evens(list));
    }


    public int sum(ArrayList<Integer> list) {
        int total = 0;
    for(Integer i : list){
        total = i + total;
    }
    return total;
    }

    public int min(ArrayList<Integer> list) {
    int min = Integer.MAX_VALUE;
    for(Integer i : list){
        if(i < min){
            min = i;
        }
    }
    return min;
    }

    public int max(ArrayList<Integer> list) {
    int max = Integer.MIN_VALUE;
    for(Integer i : list){
        if(i > max){
            max = i;
        }
    }
    return max;
    }
    public double average(ArrayList<Integer> list) {
        double sum = 0;
        for (Integer i : list) {
            sum = sum + i;
        }
        return sum / list.size();
    }

    public int zeroes(ArrayList<Integer> list) {
        int amount = 0;
        for(Integer i : list){
            if(i==0){
                amount++;
            }
        }
        return amount;
    }

    public ArrayList<Integer> evens(ArrayList<Integer> list) {
        ArrayList<Integer> evens = new ArrayList<>();
        for(Integer i : list){
            if(i%2==0){
                evens.add(i);
            }
        }
        return evens;
    }
}
