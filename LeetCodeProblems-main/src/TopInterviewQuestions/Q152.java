class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        for(int i=1;i< nums.length;i++){
            int cur = nums[i];
            int max_cur = max * cur;
            int min_cur = min * cur;
            max = Math.max(cur, Math.max(max_cur, min_cur));
            min = Math.min(cur, Math.min(max_cur, min_cur));
            res = Math.max(res, max);
        }
        return res;
    }
}
