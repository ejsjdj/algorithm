import java.io.*;
import java.util.*;

public class Main {
    static boolean[] broken = new boolean[10];  
    
    static boolean isPossible(int num) {
        if (num == 0) return !broken[0];
        while (num > 0) {
            if (broken[num % 10]) return false;
            num /= 10;
        }
        return true;
    }
    
    static int getDigitCount(int num) {
        if (num == 0) return 1;
        int cnt = 0;
        while (num > 0) {
            cnt++;
            num /= 10;
        }
        return cnt;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        
        int answer = Math.abs(N - 100);
        
        for (int i = 0; i <= 1000000; i++) {
            if (isPossible(i)) {
                int pressCount = getDigitCount(i) + Math.abs(i - N);
                answer = Math.min(answer, pressCount);
            }
        }
        
        System.out.println(answer);
    }
}
