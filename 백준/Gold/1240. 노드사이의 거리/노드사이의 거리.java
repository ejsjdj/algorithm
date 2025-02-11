import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 노드 클래스 정의 (우선순위 큐에서 사용할 Comparable 구현)
class Node implements Comparable<Node> {
    int index; // 노드 번호
    int distance; // 현재까지의 최단 거리
    List<Node> neighbors = new ArrayList<>(); // 인접 노드 리스트

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance); // 거리 기준 오름차순 정렬
    }
}

public class Main {
    private static final int INF = Integer.MAX_VALUE; // 무한대 값 정의 (최단 거리 초기화에 사용)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken()); // 노드의 개수
        int queryCount = Integer.parseInt(st.nextToken()); // 알고싶은 노드 쌍의 개수

        // 각 노드를 저장할 배열 생성 (1-based indexing 사용)
        Node[] nodes = new Node[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            nodes[i] = new Node(i, INF); // 각 노드를 초기화 (거리: 무한대)
        }

        // 간선 정보 입력 및 인접 리스트 구성
        for (int i = 0; i < nodeCount - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken()); // 두 노드 사이의 거리

            nodes[from].neighbors.add(new Node(to, weight)); // 양방향 간선 추가
            nodes[to].neighbors.add(new Node(from, weight));
        }

        // M개의 쿼리 처리
        for (int queryIndex = 0; queryIndex < queryCount; queryIndex++) {
            st = new StringTokenizer(br.readLine());
            int startNodeIndex = Integer.parseInt(st.nextToken()); // 시작 노드
            int endNodeIndex = Integer.parseInt(st.nextToken());   // 종료 노드

            // 다익스트라 알고리즘 실행
            int shortestDistance = dijkstra(nodes, startNodeIndex, endNodeIndex);

            // 결과 출력
            System.out.println(shortestDistance);
        }
    }
    private static int dijkstra(Node[] nodes, int startNodeIndex, int endNodeIndex) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        // 모든 노드의 최단 거리를 초기화 (무한대로 설정)
        for (int i = 1; i < nodes.length; i++) {
            nodes[i].distance = INF;
        }

        // 시작 노드의 최단 거리를 0으로 설정하고 큐에 추가
        nodes[startNodeIndex].distance = 0;
        priorityQueue.add(nodes[startNodeIndex]);

        // 우선순위 큐를 이용한 다익스트라 알고리즘 수행
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll(); // 현재 최단 거리가 가장 짧은 노드 꺼내기

            for (Node neighbor : currentNode.neighbors) {
                // 현재 경로를 통해 이웃 노드로 가는 거리를 계산
                int newDistance = currentNode.distance + neighbor.distance;

                if (newDistance < nodes[neighbor.index].distance) {
                    // 더 짧은 경로를 발견하면 업데이트하고 큐에 추가
                    nodes[neighbor.index].distance = newDistance;
                    priorityQueue.add(nodes[neighbor.index]);
                }
            }
        }

        return nodes[endNodeIndex].distance; // 종료 노드까지의 최단 거리 반환
    }
}