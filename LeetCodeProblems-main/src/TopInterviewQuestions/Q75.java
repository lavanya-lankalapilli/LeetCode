class Solution {
    public void sortColors(int[] nums) {
        int p0=0, p2=nums.length-1, cur = 0;
        while (cur <= p2){
            if(nums[cur] == 0){
                nums[cur++] = nums[p0];
                nums[p0++] = 0;
            } else if (nums[cur] == 2) {
                nums[cur] = nums[p2];
                nums[p2--] = 2;
            } else {
                cur++;
            }
        }

    }
}
