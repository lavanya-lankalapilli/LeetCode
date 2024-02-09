import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /*public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        Str
        for(int i=0;i<s.length();i++){
            str.append(s.charAt(i));
            if(wordDict.contains(str.toString())){
                if(wordBreak(s.substring(i+1), wordDict)){
                    return true;
                }
            }
        }
        return false;
    }*/

   /* public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        for (String str : wordDict) {
            if (s.startsWith(str) && wordBreak(s.substring(str.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }*/

    Boolean memo[];
    List<String> wordDict;
    String s;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        this.wordDict = wordDict;
        this.s = s;
        return wordBreak(s.length() - 1);
    }


    public boolean wordBreak(int i) {
        if (i < 0) {
            return true;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        for (String word : wordDict) {
            if (i - word.length() + 1 >= 0 &&
                    s.substring(i - word.length() + 1, i+1).equals(word) &&
                    wordBreak(i - word.length())) {
                memo[i] = true;
                return true;
            }
        }
        memo[i] = false;
        return false;
    }


    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(new Solution().wordBreak(s, wordDict));
    }


}
