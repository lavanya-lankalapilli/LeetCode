package TopInterviewQuestions;

public class Stocks {
    public int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else if ((prices[i] - min) > profit)
                profit = (prices[i] - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Stocks s = new Stocks();
        System.out.println(s.maxProfit(prices));
    }
}
