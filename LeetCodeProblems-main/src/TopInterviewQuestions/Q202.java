class Solution {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 1) {
            int sum = 0, temp = n;
            while (temp > 0) {
                sum += Math.pow(temp % 10, 2);
                temp /= 10;
            }
            if (list.contains(sum)) {
                return false;
            } else {
                list.add(sum);
            }
            n = sum;
        }
        return true;
    }
}
