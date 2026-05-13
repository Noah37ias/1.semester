package opg3;

import java.util.ArrayList;

public class InsertionSort {
    void main(){
        String[] navne = {"Noah","Arian","Carsten","Noah"};
        IO.println(navne.length);
        Customer c1 = new Customer("Noah",100);
        Customer c2 = new Customer("Carsten",150);
        Customer c3 = new Customer("Arian",200);
        Customer c4 = new Customer("Arian",250);
        Customer c5 = new Customer("Arian",100);
        Customer c6 = new Customer("Arian",300);

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        customers.add(c6);


    }
}
