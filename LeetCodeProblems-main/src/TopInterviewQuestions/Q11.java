public class Q11 {
    public int maxArea(int[] height) {
        int res = Integer.MIN_VALUE, temp = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                temp = height[left] * (right - left);
                left++;
            } else {
                temp = height[right] * (right - left);
                right--;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
