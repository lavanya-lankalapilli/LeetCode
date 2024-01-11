class Solution {
   public int maxProfit(int[] prices) {
        int profit = 0, buy = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1] && prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] > prices[i + 1] && prices[i] > buy) {
                profit += (prices[i] - buy);
                buy = prices[i + 1];
            }
        }
        
        if (prices.length > 0 && prices[prices.length - 1] > buy) {
            profit += (prices[prices.length - 1] - buy);
        }

        return profit;
    }
}
