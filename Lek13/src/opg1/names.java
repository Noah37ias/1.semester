package opg1;

import java.util.ArrayList;

public class names {
    void main(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Hans");
        names.add("Viggo");
        names.add("Jens");
        names.add("Bente");
        names.add("Bent");

        for(String name : names){
            System.out.println(name);
        }

        names.add(2,"Jane");
        for(String name : names){
            System.out.println(name);
        }

        names.remove(1);
        names.add("Pia");
        names.add(0,"Ib");
        IO.println(names.size());

        names.set(2,"Hansi");
        IO.println(names.size());
        for(String name : names){
            IO.println(name);
        }
        IO.println("Opgave 13");
        for(int i = 0; i < names.size(); i++){
            String name = names.get(i);
            IO.println(name.length());
        }
        IO.println("Opgave 14");
        for(String name : names){
            IO.println(name.length());
        }
    }
}
