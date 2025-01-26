import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int targetNode; // 이동할 정점
    int value;      // 가중치

    public Node(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.value, o.value); // 가중치 오름차순 정렬
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        
        // 그래프 초기화
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 시작 정점 입력
        int start = Integer.parseInt(br.readLine());

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발 정점
            int v = Integer.parseInt(st.nextToken()); // 도착 정점
            int w = Integer.parseInt(st.nextToken()); // 가중치
            graph.get(u).add(new Node(v, w));
        }

        // 다익스트라 알고리즘 실행
        dijkstra(V, graph, start);
    }

    public static void dijkstra(int V, List<List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); // 최단 거리 배열 초기화

        distance[start] = 0; // 시작 정점의 거리는 0
        pq.offer(new Node(start, 0)); // 시작 정점을 우선순위 큐에 추가

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.targetNode;
            int currentDistance = current.value;

            // 이미 처리된 노드라면 무시
            if (currentDistance > distance[currentNode]) continue;

            // 인접 노드 탐색
            for (Node neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.targetNode;
                int weight = neighbor.value;

                // 현재 경로를 통해 더 짧은 경로를 발견한 경우 업데이트
                if (distance[currentNode] + weight < distance[nextNode]) {
                    distance[nextNode] = distance[currentNode] + weight;
                    pq.offer(new Node(nextNode, distance[nextNode]));
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
}