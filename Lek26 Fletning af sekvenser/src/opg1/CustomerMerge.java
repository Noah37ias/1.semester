package opg1;

import java.util.ArrayList;
import java.util.Collections;

public class CustomerMerge {
    void main() {
        Customer c1 = new Customer("Noah","Noah");
        Customer c2 = new Customer("Carsten","sdw");
        Customer c3 = new Customer("Arian","asfw");
        Customer c4 = new Customer("Arian","oifio");
        Customer c5 = new Customer("Arian","sfkew");
        Customer c6 = new Customer("Arian","gaks");

        ArrayList<Customer> liste1 = new ArrayList<>();
        ArrayList<Customer> liste2 = new ArrayList<>();

        liste1.add(c1);
        liste1.add(c2);
        liste1.add(c3);
        liste2.add(c4);
        liste2.add(c5);
        liste2.add(c6);
        Collections.sort(liste1);
        Collections.sort(liste2);
        IO.println(mergeAllCustomers(liste1,liste2));

    }

    public ArrayList<Customer> mergeAllCustomers(ArrayList<Customer> l1, ArrayList<Customer> l2) {
        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while(i1 < l1.size()&&i2<l2.size()){
            if(l1.get(i1).compareTo(l2.get(i2))<=0){
                result.add(l1.get(i1));
                i1++;
            }
            else{
                result.add(l2.get(i2));
                i2++;
            }
        }
        while(i1<l1.size()){
            result.add(l1.get(i1));
            i1++;
        }
        while(i2<l2.size()){
            result.add(l2.get(i2));
            i2++;
        }
        return result;
    }
}
