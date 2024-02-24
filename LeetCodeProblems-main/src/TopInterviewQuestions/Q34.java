class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) {
            return result;
        }
        searchRange(nums, target, 0, nums.length - 1, result);
        return result;
    }

    private void searchRange(int[] nums, int target, int left, int right, int[] result) {
        if (right < left) {
            return;
        }
        int mid = (right - left) / 2 + left;
        if (nums[mid] == target) {
            if (result[0] == -1 && mid == 0 || nums[mid - 1] < target) {
                result[0] = mid;
            } else {
                searchRange(nums, target, left, mid - 1, result);
            }
            if (result[1] == -1 && mid == nums.length - 1 || nums[mid + 1] > target) {
                result[1] = mid;
            } else {
                searchRange(nums, target, mid + 1, right, result);
            }
        } else if (nums[mid] > target) {
            searchRange(nums, target, left, mid - 1, result);
        } else {
            searchRange(nums, target, mid + 1, right, result);
        }
    }
}
