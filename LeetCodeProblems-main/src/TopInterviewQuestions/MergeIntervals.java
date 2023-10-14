package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;

class Solution56_bruteforce {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        int[] current_interval = intervals[0];
        res.add(current_interval);
        for (int[] interval : intervals) {
            if (current_interval[1] >= interval[0]) {
                current_interval[1] = Math.max(current_interval[1], interval[1]);
            } else {
                current_interval = interval;
                res.add(current_interval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}

public class MergeIntervals {

    public static void main(String[] args) {
        Solution56_bruteforce sol = new Solution56_bruteforce();
        int[][] intervals = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        int[][] res = sol.merge(intervals);
        for (int[] inter : res) {
            System.out.println(inter[0] + "-" + inter[1]);
        }
    }
}
