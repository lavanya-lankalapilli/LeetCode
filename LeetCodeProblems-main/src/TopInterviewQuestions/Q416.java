class Solution {
    Boolean dp[][];

    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        dp = new Boolean[nums.length][sum + 1];
        return canParitionUtil(nums, 0, sum, 0);
    }

    boolean canParitionUtil(int nums[], int i, int sum, int curSum) {
        //System.out.println(curSum + " " + i);
        if (curSum == sum) {
            return true;
        }
        if (i >= nums.length || curSum > sum) {
            return false;
        }
        if (dp[i][curSum] != null) {
            return dp[i][curSum];
        }
        boolean result =  (canParitionUtil(nums, i + 1, sum, curSum)) ||
                canParitionUtil(nums, i + 1, sum, curSum + nums[i]);
        dp[i][curSum] = result;
        return result;
    }
}
