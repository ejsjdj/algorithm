import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] tree;
    static int[] lazy;
    static int start;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        start = 1;
        while (start < N) start = start * 2;

        tree = new int[start * 2];
        lazy = new int[start * 2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                update(b, c, 1, 0, start - 1);
            } else {
                sb.append(query(b, c, 1, 0, start - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void update(int left, int right, int node, int nodeLeft, int nodeRight) {
        push(node, nodeLeft, nodeRight);

        if (nodeLeft > right || nodeRight < left) return;

        if (nodeLeft >= left && nodeRight <= right) {
            lazy[node] ^= 1;
            push(node, nodeLeft, nodeRight);
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(left, right, node * 2, nodeLeft, mid);
        update(left, right, node * 2 + 1, mid + 1, nodeRight);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void push(int node, int nodeLeft, int nodeRight) {
        if (lazy[node] != 0) {
            tree[node] = (nodeRight - nodeLeft + 1) - tree[node];

            if (nodeLeft != nodeRight) {
                lazy[node * 2] ^= 1;
                lazy[node * 2 + 1] ^= 1;
            }
            lazy[node] = 0;
        }
    }

    static int query(int left, int right, int node, int nodeLeft, int nodeRight) {
        push(node, nodeLeft, nodeRight); // 1. 조회 전에도 밀어주기

        if (nodeLeft > right || nodeRight < left) return 0;
        if (left <= nodeLeft && nodeRight <= right) return tree[node];

        int mid = (nodeLeft + nodeRight) / 2;
        return query(left, right, node * 2, nodeLeft, mid) + query(left, right, node * 2 + 1, mid + 1, nodeRight);
    }
}
