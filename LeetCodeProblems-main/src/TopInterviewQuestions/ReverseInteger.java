package TopInterviewQuestions;

public class ReverseInteger {
    public int reverse(int x) {
        int r = 0, temp = x, pop;
        x = Math.abs(x);
        while (x > 0) {
            pop = x % 10;
            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            r = r * 10 + pop;
            x = x / 10;
        }
        if (temp > 0)
            return r;
        else
            return r * (-1);
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1534236469));
    }
}
