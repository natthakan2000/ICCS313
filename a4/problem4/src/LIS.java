public class LIS {
    static int longestIncreasingSubsequence(int[] arr) {
        int lis[] = new int[arr.length];
        int i,j,max = 0;
        for ( i = 0; i < arr.length; i++ )
            lis[i] = 1;
        for ( i = 1; i < arr.length; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
        for ( i = 0; i < arr.length; i++ )
            if ( max < lis[i] )
                max = lis[i];

        return max;
    }
}
