package TopInterviewQuestions;

import java.util.*;

public class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            if (i == 0 || nums[i] != nums[i - 1])
                twoSum(nums, i, result);
        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int l = i + 1, h = nums.length - 1;
        while (l < h) {
            int sum = nums[i] + nums[l] + nums[h];
            if (sum > 0)
                h--;
            else if (sum < 0)
                l++;
            else {
                result.add(Arrays.asList(nums[i], nums[l++], nums[h]));
                while (l < h && nums[l] == nums[l - 1])
                    l++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Sum3 sum3 = new Sum3();
        System.out.println(sum3.threeSum(nums));
    }
}
