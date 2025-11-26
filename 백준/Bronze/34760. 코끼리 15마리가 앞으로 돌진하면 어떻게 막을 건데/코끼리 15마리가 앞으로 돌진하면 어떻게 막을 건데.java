import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[15];
        int maxNose = 0;
        int firstMaxIdx = -1;
        
        for (int i = 0; i < 15; i++) {
            A[i] = sc.nextInt();
            if (A[i] > maxNose) {
                maxNose = A[i];
                firstMaxIdx = i;
            }
        }

        if (firstMaxIdx == 14) {
            System.out.println(maxNose);
        } else {
            System.out.println(maxNose + 1);
        }
    }
}
