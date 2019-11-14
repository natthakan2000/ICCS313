import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class longestCommonSubsequence {
        static int[] longestCommonSubsequence(int[] a, int[] b) {
            int m = a.length;
            int n = b.length;
            int[][] array = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 || j == 0) {
                        array[i][j] = 0;
                    } else if (a[i - 1] == b[j - 1]) {
                        array[i][j] = 1 + array[i - 1][j - 1];
                    } else {
                        array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                    }
                }
            }
            int total = array[m][n];
            int arr[] = new int[total];
            int sum = total - 1;
            while (total > 0) {
                int tmp = array[m][n];
                int tmp1 = array[m - 1][n];
                int tmp2 = array[m][n - 1];
                if (tmp == tmp1) {
                    m--;
                } else if (tmp == tmp2) {
                    n--;
                } else {
                    n--;
                    m--;
                    total--;
                    arr[sum--] = b[n];
                }
            }
            return arr;
        }
}
