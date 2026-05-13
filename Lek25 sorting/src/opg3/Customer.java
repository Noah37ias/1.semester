package opg3;

public class Customer implements Comparable<Customer>{
    private String name;
    private int money;

    public Customer(String name, int money){
        this.name = name;
        this.money = money;
    }
    public String toString(){
        return name + " - " + money;
    }
    @Override
    public int compareTo(Customer other) {
        int comparedNames = this.name.compareTo(other.name);
        if(comparedNames!=0){
            return comparedNames;
        }
        return Integer.compare(this.money,other.money);

    }
}
