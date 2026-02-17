import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] tree, lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int start = 1;
        while (start < N) {
            start *= 2;
        }

        tree = new int[start * 2];
        lazy = new int[start * 2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            tree[start + i] = Integer.parseInt(st.nextToken());
        }


        for (int i = start - 1; i > 0; i--) {
            tree[i] = tree[i * 2] ^ tree[i * 2 + 1];
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            if (type == 1) {
                int k = Integer.parseInt(st.nextToken());
                update(a, b, k, 1, 0, start - 1);
            } else {
                sb.append(query(a, b, 1, 0, start - 1)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void push(int node, int nodeLeft, int nodeRight) {
        if (lazy[node] == 0) return;

        int len = nodeRight - nodeLeft + 1;
        if ((len & 1) == 1) tree[node] ^= lazy[node];

        if (nodeLeft != nodeRight) {
            lazy[node * 2] ^= lazy[node];
            lazy[node * 2 + 1] ^= lazy[node];
        }
        lazy[node] = 0;
    }

    static void update(int left, int right, int newValue, int node, int nodeLeft, int nodeRight) {
        push(node, nodeLeft, nodeRight);

        if (right < nodeLeft || nodeRight < left) return;

        if (left <= nodeLeft && nodeRight <= right) {
            lazy[node] ^= newValue;
            push(node, nodeLeft, nodeRight);
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(left, right, newValue, node * 2, nodeLeft, mid);
        update(left, right, newValue, node * 2 + 1, mid + 1, nodeRight);
        tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
    }

    static int query(int left, int right, int node, int nodeLeft, int nodeRight) {
        push(node, nodeLeft, nodeRight);

        if (right < nodeLeft || nodeRight < left) return 0;

        if (left <= nodeLeft && nodeRight <= right) {
            return tree[node];
        }

        int mid = (nodeLeft + nodeRight) / 2;
        return query(left, right, node * 2, nodeLeft, mid) ^
                query(left, right, node * 2 + 1, mid + 1, nodeRight);
    }
}