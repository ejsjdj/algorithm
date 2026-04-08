import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int K;

    static long[] tree, lazy;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        tree = new long[N * 4];
        lazy = new long[N * 4];

        build(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                long val = Long.parseLong(st.nextToken());
                update(left, right, 1, val, 1, N);
            } else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                sb.append(query(left, right, 1, 1, N)).append("\n");
            }




        }
        System.out.println(sb);


    }

    static void build(int node, int nodeLeft, int nodeRight) throws IOException {
        if (nodeLeft == nodeRight) {
            tree[node] = Long.parseLong(br.readLine());
        } else {
            int mid = (nodeLeft + nodeRight) / 2;
            build(2 * node, nodeLeft, mid);
            build(2 * node + 1, mid + 1, nodeRight);
            tree[node] = pushUp(node, nodeLeft, nodeRight);
        }



    }

    static long pushUp(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) return tree[node];
        else return tree[2 * node] + tree[2 * node + 1];
    }

    static void propagation(int node, int nodeLeft, int nodeRight) {
        tree[node] += (nodeRight - nodeLeft + 1) * lazy[node];

        if (nodeLeft != nodeRight) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }

    static void update(int left, int right, int node, long val, int nodeLeft, int nodeRight) {
        if (lazy[node] != 0) propagation(node, nodeLeft, nodeRight);

        if (left > nodeRight || nodeLeft > right) return;

        if (left <= nodeLeft && nodeRight <= right) {
            lazy[node] += val;
            propagation(node, nodeLeft, nodeRight);
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;

        update(left, right, 2 * node, val, nodeLeft, mid);
        update(left, right, 2 * node + 1, val, mid + 1, nodeRight);
        tree[node] = pushUp(node, nodeLeft, nodeRight);
    }

    static long query(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (lazy[node] != 0) propagation(node, nodeLeft, nodeRight);
        if (left > nodeRight || nodeLeft > right) return 0;

        if (left <= nodeLeft && nodeRight <= right) return tree[node];

        int mid = (nodeLeft + nodeRight) / 2;

        return query(left, right, 2 * node, nodeLeft, mid) +
                query(left, right, 2 * node + 1, mid + 1, nodeRight);
    }

}
