package opg1;

public class Customer implements Comparable<Customer>{
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Customer other) {
        int lastName = this.lastName.compareToIgnoreCase(other.lastName);
        if(lastName==0){
            return this.firstName.compareToIgnoreCase(other.firstName);
        }
        return lastName;
    }
    public String toString(){
        return firstName + " " + lastName;
    }
}
