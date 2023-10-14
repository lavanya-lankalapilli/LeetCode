package TopInterviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0};
        int target = -1;
        TwoSum twoSum = new TwoSum();
        int res[] = twoSum.twoSum2(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] twoSum2(int[] numbers, int target) {
        int l = 0, h = numbers.length - 1;
        while (l < h) {
            int sum = numbers[l] + numbers[h];
            if (target == (sum))
                return new int[]{l+1, h+1};
            if (sum > target)
                h--;
            else
                l++;
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("no solution");
    }

}
