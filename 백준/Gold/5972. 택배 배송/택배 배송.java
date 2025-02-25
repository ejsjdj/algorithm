import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int vertex;
    int length;

    public Node(int vertex, int length) {
        this.vertex = vertex;
        this.length = length;
    }

    @Override
    public int compareTo(Node o) {
        return this.length - o.length; // 오름차순 정렬
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, length));
            graph.get(e).add(new Node(s, length)); // 양방향 그래프
        }

        // 다익스트라 알고리즘
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int nowVertex = current.vertex;

            if (visited[nowVertex]) continue; // 이미 방문한 경우 스킵
            visited[nowVertex] = true;

            for (Node next : graph.get(nowVertex)) {
                if (!visited[next.vertex] && dist[next.vertex] > dist[nowVertex] + next.length) {
                    dist[next.vertex] = dist[nowVertex] + next.length;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        System.out.println(dist[N] == Integer.MAX_VALUE ? -1 : dist[N]);
    }
}