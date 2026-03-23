package opg1;

public class Person {
    private String firstName;
    private String title;
    private boolean senior;

    public Person(String firstName, String title, boolean senior) {
        this.firstName = firstName;
        this.title = title;
        this.senior = senior;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSenior() {
        return senior;
    }
    public void setSenior(boolean senior) {
        this.senior = senior;
    }
    @Override
    public String toString() {
        return title + " " + firstName + " " + (senior ? "(senior)" : "");
    }
}
