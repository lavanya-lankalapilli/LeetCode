package TopInterviewQuestions;

//238. Product of Array Except Self
public class ArrayProduct {
    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int res[] = new int[len], l[] = new int[len], r[] = new int[len];
        l[0] = 1;
        for (int i = 1; i < len; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        r[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = l[i] * r[i];
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int res[] = new int[len], leftProd = 1, r[] = new int[len];
        r[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = leftProd * r[i];
            leftProd *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int res[] = new int[len], r = 1;
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            res[i] = r * res[i];
            r *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        int res[] = new ArrayProduct().productExceptSelf(nums);
        for (int i : res)
            System.out.println(i);
    }
}
