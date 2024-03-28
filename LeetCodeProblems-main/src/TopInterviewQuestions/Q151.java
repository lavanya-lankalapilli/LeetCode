class Solution {
     public String reverseWords(String s) {
        String[] split = s.split("\s+");
        StringBuilder res = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if(split[i]!=""){
                res.append(split[i] + " ");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
