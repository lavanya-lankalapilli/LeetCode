
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q131 {

   /* List<List<String>> res;
    Boolean[][] dp;

    public List<List<String>> partition(String s) {
        dp = new Boolean[s.length()][s.length()];
        res = new LinkedList<>();
        expandAroundCenter(0, s, new ArrayList<>());
        return res;
    }

    void expandAroundCenter(int start, String s, ArrayList<String> l) {
        if (start >= s.length()) {
            res.add((List<String>) l.clone());
        }
        for (int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i + 1);
            if (isPalindrome(s, start, i)) {
                l.add(cur);
                expandAroundCenter(i + 1, s, l);
                l.remove(l.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        //System.out.println(start + " " + end);
        for (int i = start, j = end; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                dp[start][end] = false;
                return false;
            }
        }
        dp[start][end] = true;
        return true;
    }
*/

    List<List<String>> res;
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()];
        res = new LinkedList<>();
        expandAroundCenter(0, s, new ArrayList<>());
        return res;
    }

    void expandAroundCenter(int start, String s, ArrayList<String> l) {
        if (start >= s.length()) {
            res.add((List<String>) l.clone());
        }
        for (int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i + 1);
            if (s.charAt(start) == s.charAt(i) && (i-start <= 2 || dp[start+1][i - 1])) {
                dp[start][i] = true;
                l.add(cur);
                expandAroundCenter(i + 1, s, l);
                l.remove(l.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q131().partition("aabbcaa"));
    }
}
