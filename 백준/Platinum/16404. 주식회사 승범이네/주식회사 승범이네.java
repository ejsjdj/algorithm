import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int timer = 0;

    static BufferedReader br;
    static StringTokenizer st;

    static long[] fenwick;

    static int[] in;
    static int[] out;

    static StringBuilder sb = new StringBuilder();

    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fenwick = new long[N + 1];
        in = new int[N + 1];
        out = new int[N + 1];

        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int conn = Integer.parseInt(st.nextToken());
            if (conn == -1) continue;
            adj[conn].add(i);
        }

        dfs(1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if (query == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                updateRange(idx, val);
            }
            else {
                int idx = Integer.parseInt(st.nextToken());
                sb.append(getPoint(in[idx])).append('\n');
            }
        }
        System.out.println(sb);

    }

    static void dfs(int idx) {
        in[idx] = ++timer;
        for (int conn : adj[idx]) {
            dfs(conn);
        }
        out[idx] = timer;
    }

    static void updateRange(int idx, int val) {
        update(in[idx], val);
        update(out[idx] + 1, -val);
    }

    static void update(int idx, int val) {
        while (idx <= N) {
            fenwick[idx] += val;
            idx += idx & -idx;
        }
    }

    static long getPoint(int idx) {
        long result = 0;
        while (idx > 0) {
            result += fenwick[idx];
            idx -= idx & -idx;
        }
        return result;
    }

}