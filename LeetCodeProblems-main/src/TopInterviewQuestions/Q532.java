class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] - nums[i] == k) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
  /*
public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, left = 0, right = 1, sum;
        while (right < nums.length && left < nums.length) {
            sum = nums[right] - nums[left];
            if (left == right || sum < k) {
                right++;
            } else if (sum > k) {
                left++;
            } else {
                count++;
                left++;
                while (left < nums.length && nums[left] == nums[left -1]){
                    left++;
                }
            }
        }
        return count;
    }
  */
}
