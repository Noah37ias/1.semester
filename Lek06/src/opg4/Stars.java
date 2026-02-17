package opg4;

public class Stars {
    void main() {
        exA(10);
        IO.println();

        exB(10);
        IO.println();

        exC(10);
        IO.println();

        exD(10);
        IO.println();
    }

    public void exA(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            IO.print(String.format("%2d: ", row));

            // print stars
            int starCount = rowCount - row + 1;
            for (int i = 1; i <= starCount; i++) {
                IO.print('*');
            }

            // print dashes
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                IO.print('-');
            }

            IO.println();
        }
    }

    public static void exB(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            IO.print(String.format("%2d: ", row));

            // print stars
            int starCount = rowCount - row;//Vi har fjernet plus +
            for (int i = 1; i <= starCount; i++) {
                IO.print('-');//Ændret fra * til -
            }

            // print dashes
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                IO.print('*');//Ændret fra - til *
            }

            IO.println();
        }

    }

    public static void exC(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            IO.print(String.format("%2d: ", row));


            int starCount = rowCount - row + 1;

            int dashCount = rowCount - starCount;

            // print dashes
            for (int i = 1; i <= dashCount; i++) { //Byttet om på rækkefølgen
                IO.print('-');
            }

            // print stars
            for (int i = 1; i <= starCount; i++) { //Byttet om på rækkefølgen
                IO.print('*');
            }


            IO.println();
        }
    }

    public static void exD(int rowCount) {
        int middle = rowCount / 2;//Find midten af antal rows
        IO.println(middle);//til tjek
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            IO.print(String.format("%2d: ", row));

            int effectiveRow = row;
            if (row > middle) {
                effectiveRow = rowCount - row + 1;
            }

            int dashCount = middle - effectiveRow;
            int starCount = 2 * effectiveRow - 1;

            // print dashes
            for (int i = 1; i <= dashCount; i++) {
                IO.print('-');
            }

            // print stars
            for (int i = 1; i <= starCount; i++) {
                IO.print('*');
            }

            for (int i = 1; i <= dashCount; i++) {
                IO.print('-');
            }

            IO.println();
        }
    }
}

