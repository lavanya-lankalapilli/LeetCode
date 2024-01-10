public class Q198 {

    /*public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int sum[] = Arrays.copyOf(nums, n);
        int sum1, sum2;
        for (int i = 2; i < n; i++) {
            sum2 = Integer.MIN_VALUE;
            sum1 = sum[i] + sum[i - 2];
            if (i - 3 >= 0) {
                sum2 = sum[i] + sum[i - 3];
            }
            sum[i] = Math.max(sum1, sum2);
        }
        return Math.max(sum[n - 1], sum[n - 2]);
    }*/

   /* public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n==2) {
            return Math.max(nums[0], nums[1]);
        }
        List<Integer> queue = new LinkedList<>();
        queue.add(nums[0]);
        queue.add(nums[1]);
        queue.add(nums[2] + nums[0]);
        int sum1, sum2;
        for (int i = 3; i < n; i++) {
            sum1 = nums[i] + queue.get(1);
            sum2 = nums[i] + queue.get(0);
            queue.add(Math.max(sum1, sum2));
            if(queue.size()>=4){
                queue.remove(0);
            }
        }
        return Math.max(queue.get(queue.size()-1), queue.get(queue.size()-2));
    }*/

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int prev = nums[0], prevMinusOne = 0;
        for (int i = 1; i < n; i++) {
            int current = Math.max(prev, prevMinusOne + nums[i]);
            prevMinusOne = prev;
            prev = current;
        }
        return Math.max(prev, prevMinusOne);
    }

    public static void main(String[] args) {
        int nums[] = {2, 1, 1, 2};//{2,7,9,3,1};
        System.out.println(new Q198().rob(nums));
    }
}
