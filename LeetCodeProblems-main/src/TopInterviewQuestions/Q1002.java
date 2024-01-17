class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        if (words == null || words.length == 0) {
            return result;
        }

        // Count the frequency of characters in the first word
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : words[0].toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Iterate through the rest of the words and update the character frequency
        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> tempCount = new HashMap<>();
            for (char c : words[i].toCharArray()) {
                tempCount.put(c, tempCount.getOrDefault(c, 0) + 1);
            }

            // Update the character frequency based on the minimum count
            for (char key : charCount.keySet()) {
                charCount.put(key, Math.min(charCount.get(key), tempCount.getOrDefault(key, 0)));
            }
        }

        // Build the result list based on the final character frequency
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            for (int count = 0; count < entry.getValue(); count++) {
                result.add(String.valueOf(entry.getKey()));
            }
        }

        return result;
    }
}
