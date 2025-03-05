import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());   // 아이의 수
        int M = Integer.parseInt(st.nextToken());   // 최대 꺼낼 수 있는 횟수
        
        long[] sasha = new long[M + 1];  // 사사가 꺼내는 사탕의 누적 합
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sasha[i] = sasha[i - 1] + Long.parseLong(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();  // 결과 저장
        for (int i = 0; i < N; i++) {
            long B = Long.parseLong(br.readLine());  // i번째 아이가 원하는 사탕 개수
            
            // Arrays.binarySearch로 원하는 사탕 개수를 충족할 최소 횟수 찾기
            int idx = Arrays.binarySearch(sasha, B);
            
            if (idx < 0) {
                idx = -(idx + 1);  // 삽입 위치 계산
            }
            
            if (idx > M) {
                sb.append("Go away!\n");  // 원하는 사탕을 충족하지 못한 경우
            } else {
                sb.append(idx).append("\n");  // 최소 횟수를 출력
            }
        }
        
        System.out.print(sb);  // 결과 출력
    }
}