import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선(도로) 정보를 담는 클래스
class Edge {
    int start;
    int end;
    int length;

    public Edge(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 마을(학생) 수
        int M = Integer.parseInt(st.nextToken()); // 도로 수
        int X = Integer.parseInt(st.nextToken()); // 파티가 열리는 마을 번호

        // 정방향 그래프(입력 그대로)
        List<Edge>[] originalList = new ArrayList[N + 1];
        // 역방향 그래프(도로 방향을 반대로)
        List<Edge>[] reversedList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            originalList[i] = new ArrayList<>();
            reversedList[i] = new ArrayList<>();
        }

        // 도로 정보 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            originalList[start].add(new Edge(start, end, length)); // 정방향 저장
            reversedList[end].add(new Edge(end, start, length));   // 역방향 저장
        }

        // X에서 각 마을로 가는 최단 거리 (귀가)
        int[] returnDist = dijkstra(originalList, X, N);
        // 각 마을에서 X로 가는 최단 거리 (출발)
        int[] goDist = dijkstra(reversedList, X, N);

        int maxTime = 0;
        // 각 학생(마을)마다 왕복 시간 계산 후 최댓값 갱신
        for (int i = 1; i <= N; i++) {
            int total = goDist[i] + returnDist[i];
            if (total > maxTime) {
                maxTime = total;
            }
        }

        System.out.println(maxTime); // 정답 출력
    }

    // 다익스트라 알고리즘 (최단 거리 구하기)
    private static int[] dijkstra(List<Edge>[] graph, int start, int N) {
        int[] distances = new int[N + 1]; // 최단 거리 저장 배열
        Arrays.fill(distances, Integer.MAX_VALUE); // 큰 값으로 초기화
        distances[start] = 0; // 시작점은 0

        // 우선순위 큐(최소힙) 사용: 현재까지의 거리 기준으로 정렬
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.length - b.length);
        pq.add(new Edge(start, start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.end;

            // 이미 더 짧은 경로가 있으면 무시
            if (current.length > distances[u]) {
                continue;
            }

            // 인접한 모든 도로(간선) 확인
            for (Edge edge : graph[u]) {
                int v = edge.end;
                int newDist = distances[u] + edge.length;
                // 더 짧은 경로 발견 시 갱신
                if (newDist < distances[v]) {
                    distances[v] = newDist;
                    pq.add(new Edge(u, v, newDist));
                }
            }
        }

        return distances; // 최단 거리 배열 반환
    }
}