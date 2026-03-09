package opg3;

public class Program {
    void main() {
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";
        //Opgave A
        IO.println(ord1.toUpperCase());

        //Opgave B
        IO.println(ord2.toLowerCase());

        //Opgave C
        IO.println(ord1 + " " + ord2);

        //Opgave D
        String ord3 = ord1 + ord2.toLowerCase();
        IO.println(ord3);

        //Opgave E
        IO.println(ord3.length());

        //Opgave F
        IO.println(ord3.substring(0, 7));

        //Opgave G
        IO.println(ord3.substring(3, 7));

        //Opgave h
        IO.println(ord3.substring(ord1.length()));
    }
}
