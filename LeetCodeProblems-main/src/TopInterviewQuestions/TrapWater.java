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

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        TrapWater trapWater = new TrapWater();
        System.out.println(trapWater.trap(height));
    }
}
