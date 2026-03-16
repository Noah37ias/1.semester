package opg4;

import java.util.ArrayList;



public class FunWithArrayList {
    void main(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 10)+1);//tal mellem 1 og 10
        }

        for(Integer i : list) {
            IO.println(i);
        }


        IO.println("Opgave 1: " + swap(list));
        IO.println("Opgave 2: " );
        IO.println("Opgave 3: "  );
        IO.println("Opgave 4: "  );
        IO.println("Opgave 5: "  );
        IO.println("Opgave 6: "  );
    }

    public ArrayList<Integer> swap(ArrayList<Integer> list){
        ArrayList<Integer> SwappedList = list;
        int lastIndex = list.size()-1;
        int lastElement = list.get(lastIndex);
        int firstElement = list.get(0);

        SwappedList.set(0, lastElement);
        SwappedList.set(lastIndex, firstElement);
        return SwappedList;
    }
    public ArrayList<Integer> zero(ArrayList<Integer> list){
        ArrayList<Integer> newList = list;

        for(Integer i : newList){

        }
        return list;
    }
}
