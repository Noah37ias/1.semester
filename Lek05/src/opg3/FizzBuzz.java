package opg3;

public class FizzBuzz {
    void main() {
        int max = Integer.parseInt(IO.readln());
        fizzBuzzPrinter(max);
    }

    public void fizzBuzzPrinter(int max) {
        int i = 0;
        while (i < max) {
            i++;

            if ((i % 3 == 0) && (i % 4 == 0)) {
                IO.println("FizzBuzz");
            } else if (i % 3 == 0) {
                IO.println("Fizz");
            } else if (i % 4 == 0) {
                IO.println("Buzz");
            } else {
                IO.println(i);
            }
        }
    }
}
