package opg3;

import opg1.Customer;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllCustomers {
    void main() {
        Customer c1 = new Customer("Noah", "Noah");
        Customer c2 = new Customer("Carsten", "sdw");
        Customer c3 = new Customer("Arian", "asfw");
        Customer c4 = new Customer("Arian", "oifio");
        Customer c5 = new Customer("Arian", "sfkew");
        Customer c6 = new Customer("Arian", "gaks");
        Customer c7 = new Customer("Noah", "Noah");
        Customer c8 = new Customer("Arian", "asfw");
        ArrayList<Customer> liste1 = new ArrayList<>();
        Customer[] liste2 = {c6, c7, c4, c5};

        liste1.add(c1);
        liste1.add(c2);
        liste1.add(c3);
//        liste2.add(c4);
//        liste2.add(c5);
//        liste2.add(c6);
//        liste2.add(c7);
        liste1.add(c8);
        Collections.sort(liste1);
        Arrays.sort(liste2);
        IO.println(goodCustomers(liste1, liste2));
    }

    public ArrayList<Customer> goodCustomers(
            ArrayList<Customer> l1, Customer[] l2
    ) {
        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).compareTo(l2[i2]) < 0) {
                result.add(l1.get(i1));
                i1++;
            } else if (l1.get(i1).compareTo(l2[i2]) > 0) {
                i2++;
            } else {
                i1++;
                i2++;
            }

        }
        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }
        return result;
    }
}
