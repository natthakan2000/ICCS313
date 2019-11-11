public class knapsack {
    static int knapsack(int k, int[] arr) {
        int element = arr.length;
        int[][] ans = new int[element+1][k+1];
        for(int i = 0; i<=element; i++){
            ans[i][0] = 1;
        }
        int max = 0;
        for(int i = 1; i <= element; i++){
            for(int j = 1; j<=k; j++){
                if(arr[i-1]<=j){
                    ans[i][j] = ans[i-1][j] + ans[i][j-arr[i-1]];
                }
                else{
                    ans[i][j] = ans[i-1][j];
                }
                if(ans[element][j]>0){
                    max = Math.max(max, j);
                }
            }
        }
        return max;
    }
}
