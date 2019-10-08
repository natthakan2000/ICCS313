public class problem4 {
    int bruteForce(int[] A){
        int counter = 0;
        int max = 0;
        int current = A[0];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i] == A[j]){
                    counter += 1;
                }
            }
            if (counter > max){
                max = counter;
                current = A[i];
            }
            counter = 0;
        }
        if (max > (A.length/2)){
            return current;
        }else{
            System.out.println("no majority element");
            return -1;
        }
    }

    public static void main(String[] args) {
        problem4 p = new problem4();
        System.out.println(p.bruteForce(new int[]{1,2,4,27,27,27,27,27,27,8,9,27}));
        System.out.println(p.bruteForce(new int[]{1,2,3,2,1,67,8,9}));
    }
}
