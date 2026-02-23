import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long[] tree;
    static long[] lazyA, lazyB;
    static final long MOD = 1_000_000_007L;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree  = new long[4 * N];
        lazyA = new long[4 * N];
        lazyB = new long[4 * N];
        Arrays.fill(lazyA, 1L);

        st = new StringTokenizer(br.readLine());
        init(1, 1, N);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int left  = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (type == 4) {
                sb.append(query(left, right, 1, 1, N)).append("\n");
            } else {
                long val = Long.parseLong(st.nextToken());
                if      (type == 1) update(left, right, 1, 1, N, 1,   val); // +v → (1, v)
                else if (type == 2) update(left, right, 1, 1, N, val, 0  ); // *v → (v, 0)
                else                update(left, right, 1, 1, N, 0,   val); // =v → (0, v)
            }
        }
        System.out.print(sb);
    }

    static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            tree[node] = Long.parseLong(st.nextToken()) % MOD;
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2,     nodeLeft, mid      );
        init(node * 2 + 1, mid + 1,  nodeRight);
        pushUp(node);
    }

    static void pushUp(int node) {
        tree[node] = (tree[2 * node] + tree[2 * node + 1]) % MOD;
    }

    static void apply(int node, int len, long mul, long add) {
        tree[node]  = (mul * tree[node] % MOD + add * len % MOD) % MOD;
        lazyA[node] = lazyA[node] * mul % MOD;
        lazyB[node] = (lazyB[node] * mul % MOD + add) % MOD;
    }

    static void propagation(int node, int nodeLeft, int nodeRight) {
        if (lazyA[node] == 1 && lazyB[node] == 0) return;
        int mid = (nodeLeft + nodeRight) / 2;
        apply(2 * node,     mid - nodeLeft + 1, lazyA[node], lazyB[node]);
        apply(2 * node + 1, nodeRight - mid,    lazyA[node], lazyB[node]);
        lazyA[node] = 1;
        lazyB[node] = 0;
    }

    static void update(int left, int right, int node, int nodeLeft, int nodeRight, long mul, long add) {
        if (right < nodeLeft || nodeRight < left) return;
        if (left <= nodeLeft && nodeRight <= right) {
            apply(node, nodeRight - nodeLeft + 1, mul, add);
            return;
        }
        propagation(node, nodeLeft, nodeRight);
        int mid = (nodeLeft + nodeRight) / 2;
        update(left, right, node * 2,     nodeLeft, mid,       mul, add);
        update(left, right, node * 2 + 1, mid + 1,  nodeRight, mul, add);
        pushUp(node);
    }

    static long query(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (left > nodeRight || right < nodeLeft) return 0;
        if (left <= nodeLeft && nodeRight <= right) return tree[node];
        propagation(node, nodeLeft, nodeRight);
        int mid = (nodeLeft + nodeRight) / 2;
        return (query(left, right, node * 2,     nodeLeft, mid      ) +
                query(left, right, node * 2 + 1, mid + 1,  nodeRight)) % MOD;
    }
}
