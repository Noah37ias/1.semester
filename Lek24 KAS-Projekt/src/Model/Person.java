package Model;

import org.jspecify.annotations.NullMarked;

@NullMarked
public class Person {
    private final String navn;

    public Person(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }
}
