package TopInterviewQuestions;

public class LongestPrefix {
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        String prefix = strs[0];
        for (String s : strs) {
            int i = 0;
            for (; i < s.length() && i < prefix.length(); i++) {
                if (prefix.charAt(i) != s.charAt(i)) {
                    if (i == 0) {
                        return "";
                    } else {
                        break;
                    }
                }
            }
            prefix = prefix.substring(0, i);
        }
        return prefix;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLen)
                minLen = s.length();
        }
        int l = 0, h = minLen;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (isCommonPrefix(strs, mid))
                l = mid + 1;
            else
                h = mid - 1;
        }
        return strs[0].substring(0, (l + h) / 2);
    }

    private boolean isCommonPrefix(String[] input, int len) {
        String s = input[0].substring(0, len);
        for (String str : input) {
            if (!str.startsWith(s))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        System.out.println(new LongestPrefix().longestCommonPrefix(input));
    }
}
