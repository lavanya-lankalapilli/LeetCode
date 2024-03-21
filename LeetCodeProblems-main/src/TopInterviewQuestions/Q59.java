class Solution {
    public int[][] generateMatrix(int n) {
        int cur = 1;
        int[][] res = new int[n][n];
        for (int s = 0; s <= n / 2; s++) {
            ///------->
            for (int j = s, i = s; j < n - s && cur<=(n*n); j++) {
                res[i][j] = cur++;
            }
            ///downward
            for (int j = n - s - 1, i = s + 1 ; i < n -s && cur<=(n*n); i++) {
                res[i][j] = cur++;
            }
            //left
            for (int j = n - s - 2, i = n - s - 1; j >= s && cur<=(n*n); j--) {
                res[i][j] = cur++;
            }
            //upward
            for (int j = s, i = n - s - 2; i >= s+1 && cur<=(n*n); i--) {
                res[i][j] = cur++;
            }
        }
        return res;
    }
}
