import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 길이 L부터 100까지 순서대로 확인 (가장 짧은 것부터)
        for (int len = L; len <= 100; len++) {
            long temp = (long) len * (len - 1) / 2;
            
            if (N < temp) break; // 더 이상 불가능
            
            if ((N - temp) % len == 0) {
                long x = (N - temp) / len;
                
                if (x >= 0) {
                    for (int i = 0; i < len; i++) {
                        System.out.print((x + i) + " ");
                    }
                    System.out.println();
                    return; // 가장 짧은 수열 발견시 즉시 종료
                }
            }
        }
        
        System.out.println(-1);
    }
}
