package TopInterviewQuestions;

public class Palindrome {
    public boolean isPalindrome(int x) {
        int rev = 0, orig = x;
        while (x > 0) {
            rev = (rev * 10) + (x % 10);
            x = x / 10;
        }
        return (rev == orig);
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(54345));
    }
}
