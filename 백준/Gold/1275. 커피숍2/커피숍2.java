import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = 1;
        while (start < N) start *= 2; // 리프 노드 개수 설정
        long[] tree = new long[start * 2]; // 세그먼트 트리 배열
        
        // 입력 배열 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) tree[start + i] = Integer.parseInt(st.nextToken());
        
        // 내부 노드 초기화
        for (int i = start - 1; i > 0; i--) tree[i] = tree[i * 2] + tree[i * 2 + 1];
        
        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // x와 y를 정렬하여 항상 x <= y가 되도록 설정
            int start_index = Math.min(x, y) + start - 1;
            int end_index = Math.max(x, y) + start - 1;

            // 구간합 계산
            long result = 0;
            while (start_index <= end_index) {
                if (start_index % 2 == 1) result += tree[start_index++];
                if (end_index % 2 == 0) result += tree[end_index--];
                start_index /= 2;
                end_index /= 2;
            }
            
            System.out.println(result);
            
            // 값 업데이트
            int point = a + start - 1; // 업데이트할 위치
            tree[point] = b;           // 새로운 값으로 변경
            while (point > 0) {         // 부모 노드 갱신
                point /= 2;
                tree[point] = tree[point * 2] + tree[point * 2 + 1];
            }
        }
    }
}