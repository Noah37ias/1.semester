package opg5;

import java.util.ArrayList;

public class NotSearch {
    void main(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hej");
        strings.add("Hej");
        strings.add("Hejs");
        strings.add("Hej");
        strings.add("Hejs");
        strings.add("HejJ");

        IO.println(findAllIndices(strings,"Hej"));
    }
    public static ArrayList<Integer> findAllIndices(ArrayList<String> list,String target){
        int i = 0;
        ArrayList<Integer> indexes = new ArrayList<>();
        while(i<list.size()) {
            if (list.get(i).equalsIgnoreCase(target)) {
            indexes.add(i);
            i++;
            } else i++;
        }
    return indexes;
    }
}
