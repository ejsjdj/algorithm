import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        while (T-- > 0) {
            int N = sc.nextInt(); // 건물 개수
            int K = sc.nextInt(); // 건설 순서 규칙 개수

            int[] buildTime = new int[N + 1]; // 각 건물의 건설 시간
            for (int i = 1; i <= N; i++) {
                buildTime[i] = sc.nextInt();
            }

            // 그래프와 진입차수 배열
            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            int[] indegree = new int[N + 1];

            // 건설 규칙 입력
            for (int i = 0; i < K; i++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                graph[X].add(Y);
                indegree[Y]++;
            }

            int W = sc.nextInt(); // 목표 건물

            // 위상정렬 준비
            Queue<Integer> queue = new LinkedList<>();
            int[] result = new int[N + 1]; // 각 건물의 최소 완성 시간

            // 진입차수 0인 노드(선행 건물 없는 건물) 큐에 넣기
            for (int i = 1; i <= N; i++) {
                result[i] = buildTime[i];
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            // 위상정렬 수행
            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int next : graph[now]) {
                    // 다음 건물의 최소 건설 시간 갱신
                    if (result[next] < result[now] + buildTime[next]) {
                        result[next] = result[now] + buildTime[next];
                    }
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            // 결과 출력
            System.out.println(result[W]);
        }
        sc.close();
    }
}