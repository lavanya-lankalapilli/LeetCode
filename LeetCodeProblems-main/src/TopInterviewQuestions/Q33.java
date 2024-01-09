// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class Q33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if(target>= nums[left] && target <= nums[mid]){
                    right = mid;
                } else{
                    left = mid+1;
                }
            } else{
                if(target<= nums[right] && target >= nums[mid]){
                    left = mid;
                } else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
