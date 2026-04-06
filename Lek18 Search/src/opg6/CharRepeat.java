package opg6;

public class CharRepeat {
    String s1 = "gbneookpdue";

    void main() {
        IO.println(repeatedChars(s1,2));
    }

    public boolean repeatedChars(String s, int k) {
        boolean found = false;
        int i = 0;
        while (!found && i <= s.length() - k) {
            if (match(s,k,i)){
                found = true;
            }
            else i++;
        }
        return found;
    }

    private boolean match(String s,int k,int i) {
        boolean foundDiff = false;
        int j = 1;
        char charTarget = s.charAt(i);
        while (!foundDiff && j < k) {
            char nextChar = s.charAt(i + j);
            if (charTarget != nextChar) {
                foundDiff = true;
            } else j++;
        }
        return !foundDiff;
    }
}

