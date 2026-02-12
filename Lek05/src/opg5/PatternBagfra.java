package opg5;

public class PatternBagfra {
    void main() {
        int n = Integer.parseInt(IO.readln());
        displayPattern(n);

    }

    public void displayPattern(int n) {
        int row = 1;

        while (row <= n) {
            int column = row;

            while (column >= 1) {
                IO.print(column + " ");
                column--;
            }
            IO.println();
            row++;
        }
    }
}

