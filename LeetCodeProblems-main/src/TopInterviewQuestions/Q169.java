import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q169 {

    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1, n = nums.length;
        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            if (count > n / 2) {
                return prev;
            }
            if (nums[i] == prev) {
                count++;
            } else {
                prev = nums[i];
                count = 1;
            }
        }
        return prev;
    }*/

    /*public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            if (++count > n / 2) {
                return num;
            }
            map.put(num, count);
        }
        return -1;
    }*/
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        int nums[] = {3,2,3};
        System.out.println(new Q169().majorityElement(nums));
    }


}
