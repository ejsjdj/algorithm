import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] indegree = new int[N + 1];
        int[] times = new int[N + 1];
        int[] result = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            result[i] = times[i]; // 초기값: 자기 작업시간
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                int pre = Integer.parseInt(st.nextToken());
                graph.get(pre).add(i); // 선행 작업 → 현재 작업
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                result[next] = Math.max(result[next], result[now] + times[next]);
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) answer = Math.max(answer, result[i]);
        System.out.println(answer);
    }
}
