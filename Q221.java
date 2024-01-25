

 class Solution {

    /*
   public int maximalSquare(char[][] matrix) {
        int[][] count = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            count[0][i] = (matrix[0][i] == '1') ? 1 : 0;
            ans = Math.max(ans, count[0][i]);
        }
        for (int i = 0; i < matrix.length; i++) {
            count[i][0] = (matrix[i][0] == '1') ? 1 : 0;
            ans = Math.max(ans, count[i][0]);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    count[i][j] = Math.min(count[i - 1][j - 1], Math.min(count[i - 1][j], count[i][j - 1])) + 1;
                    ans = Math.max(ans, count[i][j]);
                } else {
                    count[i][j] = 0;
                }
            }
        }
        return ans * ans;
    }
*/

    public int maximalSquare(char[][] matrix) {
        int dp[] = new int[matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            dp[i] = (matrix[0][i] == '1') ? 1 : 0;
            ans = Math.max(ans, dp[i]);
        }
        int prev, temp;
        for (int i = 1; i < matrix.length; i++) {
            prev = (matrix[i][0] == '1') ? 1 : 0;
            ans = Math.max(ans, prev);
            int j = 1;
            for (; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    temp = Math.min(dp[j - 1], Math.min(dp[j], prev)) + 1;
                } else {
                    temp = 0;
                }
                dp[j-1] = prev;
                prev = temp;
                ans = Math.max(ans, prev);
            }
            dp[j-1] = prev;
        }
        return ans * ans;
    }

    public static void main(String[] args) {

    }


}
