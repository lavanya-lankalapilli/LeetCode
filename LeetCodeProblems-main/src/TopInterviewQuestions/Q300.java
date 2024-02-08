class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n > list.get(list.size() - 1)) {
                list.add(n);
            } else {
                int j = 0;
                while (n > list.get(j)) {
                    j++;
                }
                list.set(j, n);
            }
        }
        return list.size();
    }
}
