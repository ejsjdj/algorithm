import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 두 정수를 입력받음
        BigInteger A = scanner.nextBigInteger();
        BigInteger B = scanner.nextBigInteger();

        // 두 수의 곱을 계산
        BigInteger result = A.multiply(B);

        // 결과 출력
        System.out.println(result);
    }
}