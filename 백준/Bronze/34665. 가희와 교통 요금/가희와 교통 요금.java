import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String A = br.readLine().trim();
        String B = br.readLine().trim();
        
        if (A.equals(B)) {
            // 같은 역에서 15분 후 재승차 -> 1시간 이내이므로 0원
            System.out.println(0);
        } else {
            // 다른 역에서 승차 -> 재승차 할인 불가 -> 1550원
            System.out.println(1550);
        }
    }
}