class Solution {
    int[] res;
    HashMap<Integer, List<Integer>> richMap;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        richMap = new HashMap<>();
        for (int[] pair : richer) {
            richMap.computeIfAbsent(pair[1], x -> new ArrayList<>()).add(pair[0]);
        }
        res = new int[quiet.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < quiet.length; i++) {
            dfs(i, quiet);
        }
        return res;
    }

    int dfs(int i, int quiet[]) {
        if (res[i] == -1) {
            if (richMap.containsKey(i)) {
                for (Integer richer : richMap.get(i)) {
                    int quiter = dfs(richer, quiet);
                    if(res[i] == -1){
                        res[i] = i;
                    }
                    if (quiet[quiter] < quiet[res[i]]) {
                        res[i] = quiter;
                    }
                }
            } else {
                res[i] = i;
            }
        }
        return res[i];
    }
}
