import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int[] arr = input.chars().map(ch -> ch - '0').toArray();

        // 30의 배수인지 확인하기
        int sum = 0;
        boolean isZero = false;
        for (int n : arr) {
            if(n == 0) {
                isZero = true;
            }
            sum += n;
        }

        StringBuilder sb = new StringBuilder();

        if(isZero && sum % 3 == 0) {
            Arrays.sort(arr);
            for(int i = arr.length - 1; i >= 0; i--) {
                sb.append(arr[i]);
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
        sc.close();

    }
}