public class Q53 {
    /*public int maxSubArray(int[] nums) {
        int left=0, right = 0, max = Integer.MIN_VALUE, cur = 0;
        while(right<nums.length){
            if(cur + nums[right] < nums[right]){
                cur = nums[right++];
            } else{
                cur = cur + nums[right++];
            }
            max = Math.max(max, cur);
        }
        return max;
    }*/

    public int maxSubArray(int[] nums) {
        return maxSubArrayUtil(nums, 0, nums.length - 1);
    }

    public int maxSubArrayUtil(int[] nums, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        int mid = Math.floorDiv(left + right, 2);
        int bestLeft = 0, bestRight = 0;
        int cur = 0;
        for (int i = mid - 1; i >= left; i--) {
            cur += nums[i];
            bestLeft = bestLeft > cur ? bestLeft : cur;
        }
        cur = 0;
        for (int i = mid + 1; i <= right; i++) {
            cur += nums[i];
            bestRight = bestRight > cur ? bestRight : cur;
        }

        int bestComb = nums[mid] + bestRight + bestLeft;
        int leftSum = maxSubArrayUtil(nums, left, mid - 1);
        int rightSum = maxSubArrayUtil(nums, mid + 1, right);
        return Math.max(bestComb, Math.max(leftSum, rightSum));
    }

}
