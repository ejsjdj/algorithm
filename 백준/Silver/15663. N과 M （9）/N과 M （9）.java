import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] out; // 결과를 담을 배열 (문자열 연산보다 빠름)
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        visited = new boolean[N];
        out = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 정렬 필수
        Arrays.sort(arr);

        // 2. DFS 시작
        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int level) {
        if (level == M) {
            for (int val : out) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 핵심: 현재 level(깊이)에서 이전에 선택했던 숫자를 기억함
        int lastVal = -1; 

        for (int i = 0; i < N; i++) {
            // 방문하지 않았고, 현재 레벨에서 직전에 뽑은 숫자와 다르다면 진행
            if (!visited[i] && arr[i] != lastVal) {
                visited[i] = true;
                out[level] = arr[i];
                lastVal = arr[i]; // 사용한 숫자 기록
                
                dfs(level + 1);
                
                visited[i] = false; // 백트래킹 (상태 복구)
            }
        }
    }
}