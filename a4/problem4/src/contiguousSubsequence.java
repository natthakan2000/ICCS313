import java.util.HashSet;

public class contiguousSubsequence {
    static int contiguous(int[] a) {
        int length = a.length;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            if (i > 0){
                arr[i] = Math.max(arr[i-1]+a[i],a[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
