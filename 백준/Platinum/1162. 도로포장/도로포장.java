import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int to;
    long cost;
    int count;

    Node(int to, long cost, int count) {
        this.to = to;
        this.cost = cost;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.cost, o.cost);
    }
}

public class Main {

    static int N, M, K;
    static long[][] dist;
    static List<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new long[N + 1][K + 1];
        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, cost, 0));
            adj[to].add(new Node(from, cost, 0));
        }

        dijkstra();

        long min = Long.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            min = Math.min(min, dist[N][i]);
        }
        System.out.println(min);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[1][0] = 0;
        pq.add(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.cost > dist[curr.to][curr.count]) continue;

            for (Node next : adj[curr.to]) {

                if (dist[next.to][curr.count] > dist[curr.to][curr.count] + next.cost) {
                    dist[next.to][curr.count] = dist[curr.to][curr.count] + next.cost;
                    pq.add(new Node(next.to, dist[next.to][curr.count], curr.count));
                }

                if (curr.count < K) {
                    if (dist[next.to][curr.count + 1] > dist[curr.to][curr.count]) {
                        dist[next.to][curr.count + 1] = dist[curr.to][curr.count];
                        pq.add(new Node(next.to, dist[next.to][curr.count + 1], curr.count + 1));
                    }
                }
            }
        }
    }
}