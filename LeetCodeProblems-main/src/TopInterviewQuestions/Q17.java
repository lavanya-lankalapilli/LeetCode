class Solution {
    
    Map<Integer, List<Character>> map;

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() != 0) {
            map = new HashMap<>();
            map.put(2, Arrays.asList('a', 'b', 'c'));
            map.put(3, Arrays.asList('d', 'e', 'f'));
            map.put(4, Arrays.asList('g', 'h', 'i'));
            map.put(5, Arrays.asList('j', 'k', 'l'));
            map.put(6, Arrays.asList('m', 'n', 'o'));
            map.put(7, Arrays.asList('p', 'q', 'r', 's'));
            map.put(8, Arrays.asList('t', 'u', 'v'));
            map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
            StringBuilder cur = new StringBuilder();
            helper(digits, 0, cur, result);

        }
        return result;
    }

    private void helper(String digits, int i, StringBuilder cur, List<String> result) {
        if (cur.length() == digits.length()) {
            result.add(cur.toString());
        } else {
            Integer n = Integer.parseInt(String.valueOf(digits.charAt(i)));
            for (char ch : map.get(n)) {
                cur.append(ch);
                helper(digits, i + 1, cur, result);
                cur.deleteCharAt(i);
            }
        }

    }

}
