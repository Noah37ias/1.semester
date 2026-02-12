package opg6;

public class Palindrome {
    void main() {
        int number = Integer.parseInt(IO.readln());
        int result1 = reverse(number);
        IO.println(result1);
        Boolean result2 = isPalindrome(number);
        IO.println(result2);
    }

    public int reverse(int number) {
        int reverse = 0;
        while (number > 0) {
            int lastCiffer = number % 10;
            reverse = reverse * 10 + lastCiffer;
            number = number / 10;
        }
        return reverse;
    }

    public boolean isPalindrome(int number) {
        if (number == reverse(number)) return true;
        else return false;

    }
}
