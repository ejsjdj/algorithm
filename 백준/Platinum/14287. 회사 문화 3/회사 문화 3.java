import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Integer>[] adj;
    static int timer = 0; // 정방향 증가를 위해 0으로 초기화
    static int[] in, out;
    static long[] fenwick;
    static StringTokenizer st;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        in = new int[N + 1];
        out = new int[N + 1];
        adj = new ArrayList[N + 1];
        fenwick = new long[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss != -1) adj[boss].add(i);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                update(in[idx], w);
            } else {
                int idx = Integer.parseInt(st.nextToken());
                sb.append(query(out[idx]) - query(in[idx] - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int u) {
        in[u] = ++timer;
        for (int v : adj[u]) {
            dfs(v);
        }
        out[u] = timer;
    }

    static void update(int node, int val) {
        while (node <= N) {
            fenwick[node] += val;
            node += node & -node;
        }
    }

    static long query(int node) {
        long result = 0;
        while (node > 0) {
            result += fenwick[node];
            node -= node & -node;
        }
        return result;
    }
}