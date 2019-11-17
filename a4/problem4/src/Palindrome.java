import java.util.Arrays;

public class Palindrome {
    static String palindrome(String s){
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            r.append(s.charAt(i));
        }
        int nested[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length() ; i++) {
            for (int j = 0; j < s.length() ; j++) {
                if (i == 0 || j == 0){
                    nested[i][j] = 0;
                }else if (s.charAt(i-1)== r.charAt(j-1)){
                    nested[i][j] = nested[i-1][j-1]+1;
                }else{
                    nested[i][j] = Math.max(nested[i-1][j], nested[i][j-1]);
                }
            }
        }
        int index = nested[s.length()-1][s.length()-1];
        char[] p = new char[index+1];
        int i = s.length();
        int j = s.length();
        while (i > 0 && j > 0){
            if (index != 0) {
                if (s.charAt(i-1) == r.charAt(j-1)) {
                    p[index-1] = s.charAt(i-1);
                    i--;
                    j--;
                    index--;
                }
            }else if (nested[i-1][j] > nested[i][j-1]){
                i--;
            }else {
                j--;
            }
        }
        return Arrays.toString(p);
    }
}
