class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int cur = 1,m = matrix.length, n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        for (int s = 0; s <= n / 2; s++) {
            ///------->
            for (int j = s, i = s; j < n - s && cur<=(m*n); j++) {
                result.add(matrix[i][j]);
                cur++;
            }
            ///downward
            for (int j = n - s - 1, i = s + 1 ; i < m -s && cur<=(m*n); i++) {
                result.add(matrix[i][j]);
                cur++;
            }
            //left
            for (int j = n - s - 2, i = m - s - 1; j >= s && cur<=(m*n); j--) {
                result.add(matrix[i][j]);
                cur++;
            }
            //upward
            for (int j = s, i = m - s - 2; i >= s+1 && cur<=(m*n); i--) {
                result.add(matrix[i][j]);
                cur++;
            }
        }
        return result;
    }
}
