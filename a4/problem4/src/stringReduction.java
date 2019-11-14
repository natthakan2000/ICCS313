public class stringReduction {
    static int stringReduction(String s) {
        int length = s.length();
        int counter[] = new int[3];
        for (int i = 0; i < length; ++i) {
            counter[s.charAt(i) - 'a']++;
        }
        if (counter[0] == length || counter[1] == length
                || counter[2] == length) {
            return length;
        }
        if ((counter[0] % 2) == (counter[1] % 2)
                && (counter[1] % 2) == (counter[2] % 2)) {
            return 2;
        }
        return 1;
    }
}
