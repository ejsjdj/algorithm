import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력받은 문자열을 BigInteger로 변환
        BigInteger sum = new BigInteger(br.readLine()); // 첫 번째 입력: 합
        BigInteger sub = new BigInteger(br.readLine()); // 두 번째 입력: 차
        
        // (sum + sub) / 2 계산
        BigInteger a = sum.add(sub).divide(BigInteger.TWO);
        
        // b = sum - a 계산
        BigInteger b = sum.subtract(a);
        
        // 결과 출력
        System.out.println(a);
        System.out.println(b);
        
        br.close();
    }
}