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
        
        int width = 1;
        while (width < N) width *= 2; // 리프 노드 개수 계산
        int start = width - 1;       // 리프 노드의 시작 인덱스
        width *= 2;                  // 전체 트리 배열 크기 계산
        
        int[] tree_max = new int[width];
        int[] tree_min = new int[width];
        
        for (int i = start; i < start + N; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            tree_max[i] = input;
            tree_min[i] = input;
        }
        
        for (int i = start - 1; i > 0; i--) { // 내부 노드 초기화
            tree_max[i] = Math.max(tree_max[i * 2], tree_max[i * 2 + 1]);
            tree_min[i] = Math.min(tree_min[i * 2], tree_min[i * 2 + 1]);
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start_index = Integer.parseInt(st.nextToken()) - 1; // 입력 인덱스 변환
            int end_index = Integer.parseInt(st.nextToken()) - 1;
            
            int minResult = Integer.MAX_VALUE;
            int maxResult = Integer.MIN_VALUE;

            start_index += start; // 리프 노드의 실제 시작 위치로 이동
            end_index += start;

            while (start_index <= end_index) {
                if (start_index % 2 == 1) { // 왼쪽 자식 포함
                    minResult = Math.min(minResult, tree_min[start_index]);
                    maxResult = Math.max(maxResult, tree_max[start_index]);
                    start_index++;
                }
                if (end_index % 2 == 0) { // 오른쪽 자식 포함
                    minResult = Math.min(minResult, tree_min[end_index]);
                    maxResult = Math.max(maxResult, tree_max[end_index]);
                    end_index--;
                }
                start_index /= 2;
                end_index /= 2;
            }

            System.out.print(minResult + " " + maxResult);
            System.out.println();
        }
    }
}