import java.math.BigInteger;

public class fibonucci {
    static BigInteger fibonucci(int t1, int t2, int n) {
        BigInteger[] a = new BigInteger[n];
        BigInteger one = new BigInteger(Integer.toString(t1));
        BigInteger two = new BigInteger(Integer.toString(t2));
        a[0] = one;
        a[1] = two;
        for(int i = 2; i < n; i++){
            BigInteger temp = a[i-1].pow(2);
            BigInteger ans = temp.add(a[i-2]);
            a[i] = ans;
        }
        return a[n-1];
    }
}
