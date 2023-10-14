package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//8. String to Integer (atoi)
public class ATOI {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        boolean negative = false;
        if (s.charAt(0) == '-') {
            negative = true;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        List<Character> digits = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (digits.contains(ch)) {
                res.append(ch);
            } else {
                break;
            }
        }
        String r = res.toString();
        if (r.isEmpty()) {
            return 0;
        } else {
            int ans;
            try {
                ans = Integer.valueOf(r);
                if (negative)
                    ans = ans * -1;
            } catch (NumberFormatException e) {
                if (negative)
                    ans = Integer.MIN_VALUE;
                else
                    ans = Integer.MAX_VALUE;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String input = "   +0 123";
        System.out.println(new ATOI().myAtoi(input));
    }
}
