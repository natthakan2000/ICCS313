public class knapsack {
    static int knapsack(int k, int[] arr) {
        int ele = arr.length;
        int[][] dp = new int[ele+1][k+1];
        for(int i = 0; i<=ele; i++){
            dp[i][0] = 1;
        }
        int max=0;
        for(int row = 1; row<=ele; row++){
            for(int col = 1; col<=k; col++){
                if(arr[row-1]<=col){
                    dp[row][col] = dp[row-1][col] + dp[row][col-arr[row-1]];
                }
                else{
                    dp[row][col] = dp[row-1][col];
                }
                if(dp[ele][col]>0){
                    max = Math.max(max, col);
                }
            }
        }
        return max;
    }
}
