package TopInterviewQuestions;

//Maximum Sub array
public class MSS {
    public int maxSubArray(int[] nums) {
        int maxCur = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(nums[i], nums[i] + maxCur);
            if (maxCur > max)
                max = maxCur;
        }
        return max;
    }

    public static void main(String[] args) {
        MSS m = new MSS();
        int[] a = {1};
        System.out.println(m.maxSubArray(a));
    }
}
