

public class Q714 {

   /* int dp[][];

    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                if(i==j){
                    dp[i][i] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        return maxProfit(prices, fee, 0, prices.length - 1);
    }

    public int maxProfit(int[] prices, int fee, int start, int end) {
        if(start > end){
            return 0;
        }
        if(start <= end && dp[start][end] != -1){
            return dp[start][end];
        }
        int profit = 0;
        for (int i = start; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int temp = prices[j] - prices[i] - fee;
                temp += maxProfit(prices, fee, j + 1, end);
                profit = Math.max(temp, profit);
            }
        }
        dp[start][end] = profit;
        return profit;
    }
*/

    /*
    public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    if (n <= 1) {
        return 0;
    }

    int[] dp = new int[n];
    dp[n - 1] = 0;

    for (int i = n - 2; i >= 0; i--) {
        int maxProfit = 0;
        for (int sellDay = i + 1; sellDay < n; sellDay++) {
            int temp = prices[sellDay] - prices[i] - fee;
            temp += (sellDay + 1 < n) ? dp[sellDay + 1] : 0;
            maxProfit = Math.max(temp, maxProfit);
        }
        dp[i] = Math.max(maxProfit, dp[i + 1]);
    }

    return dp[0];
}
     */

    /*
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int free[] = new int[n], hold[] = new int[n];
        hold[0] = - prices[0];
        for(int i=1;i<prices.length;i++){
            hold[i] = Math.max(hold[i-1], free[i-1] - prices[i]);
            free[i] = Math.max(free[i-1], hold[i-1] + prices[i] - fee);
        }
        return free[n-1];
    }

     */

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int free = 0;
        int hold = - prices[0];
        for(int i=1;i<prices.length;i++){
            int temp = hold;
            hold = Math.max(hold, free - prices[i]);
            free = Math.max(free, temp + prices[i] - fee);
        }
        return free;
    }

    public static void main(String[] args) {
        int stocks[] = {1, 3, 7, 5, 10, 3};
        System.out.println(new Q714().maxProfit(stocks, 3));

    }


}
