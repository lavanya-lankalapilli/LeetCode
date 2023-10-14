package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, l = 0, r = 0;
        Integer[] chars = new Integer[128];
        while (r < s.length()) {
            char ch = s.charAt(r);
            Integer index = chars[ch];
            if (index != null && index >= l && index < r) {
                l = index + 1;
            }
            maxLen = Math.max(r - l + 1, maxLen);
            chars[ch] = r;
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubString obj = new LongestSubString();
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }
}
