package TopInterviewQuestions;

public class TrapWater {
    public int trap(int[] height) {
        int len = height.length;
        if(len<=2)
            return 0;
        int l[] = new int[len];
        int r[] = new int[len];
        int area = 0;
        l[0] = height[0];
        for (int i = 1; i < len; i++) {
            l[i] = Math.max(l[i - 1], height[i]);
        }
        r[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            r[i] = Math.max(r[i + 1], height[i]);
        }
        for (int i = 0; i < len; i++) {
            area = area + (Math.min(r[i], l[i]) - height[i]);
        }
        return area;
    }

     /* 
     // o(n) space o(n) algo
     public int trap(int[] height) {
        int len = height.length;
        int rightMax[] = new int[len];
        rightMax[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int res = 0, leftMax = 0;
        for (int i = 0; i < len; i++) {
            int min = Math.min(leftMax, rightMax[i]);
            if (min > height[i]) {
                res += Math.abs(min - height[i]);
            }
            leftMax = Math.max(leftMax, height[i]);
        }
        return res;
    }

    // two pointer algorithm: o(1) space
    public int trap(int[] height) {
        int res = 0, leftMax = 0, left = 0, right = height.length - 1, rightMax = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
    */

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        TrapWater trapWater = new TrapWater();
        System.out.println(trapWater.trap(height));
    }
}
