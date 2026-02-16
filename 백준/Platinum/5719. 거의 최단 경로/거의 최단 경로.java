import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int to, cost;

    Node(int to, int cost) {
        this.to = to; this.cost = cost;
    }

    @Override
    public int compareTo(Node o) { return this.cost - o.cost; }
}

public class Main {
    static int N, M, S, E;
    static int[] dist;
    static List<Node>[] adj; // 정방향 그래프
    static List<Node>[] revAdj; // 역방향 그래프 (역추적용)
    static boolean[][] isShortestEdge; // 최단 경로에 포함된 간선인지 체크



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;
            
            adj = new ArrayList[N];
            revAdj = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
                revAdj[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());



            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adj[a].add(new Node(b, c));
                revAdj[b].add(new Node(a, c));
            }

            isShortestEdge = new boolean[N][N];
            dijkstra();
            backtrack();
            dijkstra();
            System.out.println(dist[E] == Integer.MAX_VALUE ? -1 : dist[E]);

        }

    }

    static void dijkstra() {
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[S] = 0;
        pq.add(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.cost > dist[curr.to]) continue;

            for (Node next : adj[curr.to]) {
                if (isShortestEdge != null && isShortestEdge[curr.to][next.to]) {
                    continue;
                }
                if (dist[next.to] > dist[curr.to] + next.cost) {
                    dist[next.to] = dist[curr.to] + next.cost;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }

    static void backtrack() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(E);
        visited[E] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (Node edge : revAdj[v]) {
                int u = edge.to;
                if (dist[u] + edge.cost == dist[v]) {
                    isShortestEdge[u][v] = true;
                    if (!visited[u]) {
                        visited[u] = true;
                        q.add(u);
                    }
                }
            }
        }
    }
}