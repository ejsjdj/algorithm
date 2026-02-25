import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays; // 배열 초기화를 위해 추가
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] in, out;
    static int[] tree, lazy;
    static int N, M;
    static int timer = 0;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        in = new int[N + 1];
        out = new int[N + 1];
        adj = new ArrayList[N + 1];

        tree = new int[4 * N];
        lazy = new int[4 * N];

        Arrays.fill(lazy, -1);

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss != 0) adj[boss].add(i);
        }

        dfs(1);

        init(1, 1, N);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int left = in[k] + 1;
            int right = out[k];

            if (left > right) { // 부하 직원이 없는 경우
                if (type == 3) sb.append(0).append("\n");
                continue;
            }

            if (type == 1) {
                update(1, 1, N, left, right, 1);
            } else if (type == 2) {
                update(1, 1, N, left, right, 0);
            } else {
                sb.append(query(left, right, 1, 1, N)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void dfs(int u) {
        in[u] = ++timer;
        for (int v : adj[u]) {
            dfs(v);
        }
        out[u] = timer;
    }

    static int init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) return tree[node] = 1;
        int mid = (nodeLeft + nodeRight) / 2;
        return tree[node] = init(node * 2, nodeLeft, mid) + init(node * 2 + 1, mid + 1, nodeRight);
    }

    static void propagate(int node, int nodeLeft, int nodeRight) {
        if (lazy[node] != -1) {
            tree[node] = (lazy[node] == 1) ? (nodeRight - nodeLeft + 1) : 0;

            if (nodeLeft != nodeRight) {
                lazy[node * 2] = lazy[node];
                lazy[node * 2 + 1] = lazy[node];
            }
            lazy[node] = -1;
        }
    }

    static void update(int node, int start, int end, int left, int right, int val) {
        propagate(node, start, end);

        if (right < start || end < left) return;

        if (left <= start && end <= right) {
            lazy[node] = val; // 숙제 기록
            propagate(node, start, end);
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, left, right, val);
        update(node * 2 + 1, mid + 1, end, left, right, val);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static int query(int left, int right, int node, int nodeLeft, int nodeRight) {
        propagate(node, nodeLeft, nodeRight);

        if (left > nodeRight || right < nodeLeft) return 0;

        if (left <= nodeLeft && nodeRight <= right) return tree[node];

        int mid = (nodeLeft + nodeRight) / 2;
        return query(left, right, node * 2, nodeLeft, mid) +
                query(left, right, node * 2 + 1, mid + 1, nodeRight);
    }
}
