class Solution {
    
    public void nextPermutation(int[] nums) {
        int l = findPair(nums) + 1;
        for (int r = nums.length - 1; l < r; l++, r--) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }

    private int findPair(int nums[]) {
        int idx[] = {-1, -1};
        int l = -1, r = nums.length - 1;
        for (; r > 0; r--) {
            if (nums[r] > nums[r - 1]) {
                l = r - 1;
                break;
            }
        }
        if(l!=-1){
            for (int i = l; i < nums.length; i++) {
                if (nums[i] > nums[l] && nums[i] <= nums[r]) {
                    r = i;
                }
            }
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
        }
        return l;
    }
}
