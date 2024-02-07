class Solution {
     public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] prev = res.get(res.size() - 1);
            if (cur[0] <= prev[1]) {
                res.get(res.size() - 1)[1] = Math.max(cur[1], prev[1]);
            } else {
                res.add(cur);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
