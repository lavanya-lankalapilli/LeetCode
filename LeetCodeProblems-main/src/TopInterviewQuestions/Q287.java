import java.util.Arrays;
import java.util.HashSet;

public class Q287 {
    //boolean visited[][];

    /*public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }*/

    /*public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }*/
}
