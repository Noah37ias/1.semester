package opg6;

public class CharRepeat {
    String s1 = "gbneookpdue";
    int i = 0;

    void main() {
        IO.println(repeatedChars(s1,3));
    }

    public boolean repeatedChars(String s, int k) {
        boolean found = false;
        while(!found&&i<s.length()) {
            if (match(s1.charAt(i),k)){
                found = true;
            }
            else i++;
        }
        return found;
    }

    private boolean match(char ch1,int k) {
        boolean foundDiff = false;
        int j = 0;

        while (i < s1.length()&& j<k) {
            char k = s1.charAt(j);
            if (ch1 == k) {
                foundDiff = true;
            } else j++;
        }
        return foundDiff;
    }
}

