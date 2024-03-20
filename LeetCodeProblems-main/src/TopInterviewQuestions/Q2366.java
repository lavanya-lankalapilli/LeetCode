class Solution {
     public long minimumReplacement(int[] nums) {
        long ans = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                long noOfElem = (nums[i + 1] + nums[i] - 1) / nums[i + 1];
                ans += noOfElem - 1;
                nums[i] = nums[i] / (int)noOfElem;
            }
        }
        return ans;
    }
}
