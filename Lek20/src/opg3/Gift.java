package opg3;

public class Gift {
    private String description;
    private double price;
    private Person giver;

    public Gift(String description, double price, Person giver) {
        this.description = description;
        this.price = price;
        this.giver = giver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public Person getGiver() {
        return giver;
    }


    @Override
    public String toString() {
        return "Gift{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
