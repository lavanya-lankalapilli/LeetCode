class Solution {
    public int maxVowels(String s, int k) {
        int max = 0, i = 0;
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Character> cur = new ArrayList<>();
        for(;i<k && i<s.length();i++){
            if(vowels.contains(s.charAt(i))){
                cur.add(s.charAt(i));
                max++;
            }
        }
        while(i<s.length()){
            Character ch = s.charAt(i-k);
            cur.remove(ch);
            ch = s.charAt(i);
            if(vowels.contains(ch)){
                cur.add(ch);
                max = Math.max(max, cur.size());
            }
            i++;
        }
        return max;
    }
}
