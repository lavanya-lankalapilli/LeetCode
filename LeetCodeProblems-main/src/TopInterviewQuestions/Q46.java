import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q46 {

    /*List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        List<Integer> cur;
        for (int i = 0; i < nums.length; i++) {
            cur = new ArrayList<>();
            cur.add(nums[i]);
            permute(cur, nums);
        }
        return result;
    }

    public void permute(List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            result.add(List.copyOf(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!cur.contains(nums[i])) {
                cur.add(nums[i]);
                permute(cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }*/


        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            permutations(nums, 0);
            return res;
        }

        private void permutations(int[] nums, int start){
            if(start == nums.length - 1){
                List<Integer> permutation = new ArrayList<>();
                for(int num: nums){
                    permutation.add(num);
                }
                res.add(permutation);
                return;
            }

            for(int i=start;i<nums.length;i++){
                swap(nums, start, i);
                permutations(nums, start + 1);
                swap(nums, start, i);
            }
        }

        private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }



    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(new Q46().permute(nums));

    }
}
