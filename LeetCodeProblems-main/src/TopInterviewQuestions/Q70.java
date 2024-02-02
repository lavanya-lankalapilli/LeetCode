class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n+1];
        if(n==1 || n==2){
            return n;
        }
        dp[1] = 1;
        dp[2] = 2;
        return fib(n);
    }

    public int fib(int n){
        if(n==1 || n==2){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }
}
