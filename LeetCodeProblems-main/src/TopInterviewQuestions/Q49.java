
import java.util.*;

public class Q49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int count[] = new int[26];
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                s.append('#');
                s.append(count[j]);
            }
            String key = s.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }

   /* public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }*/

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat", "ac", "bd", "aac", "bbd", "aacc", "bbdd", "acc", "bdd"};
        System.out.println(new Q49().groupAnagrams(strs));
    }
}
