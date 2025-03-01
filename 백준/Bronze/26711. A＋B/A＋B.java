import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열로 입력받기
        String a = sc.nextLine();
        String b = sc.nextLine();

        // BigInteger로 변환
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);

        // 두 수 더하기
        BigInteger sum = num1.add(num2);

        // 결과 출력
        System.out.println(sum);

        sc.close();
    }
}