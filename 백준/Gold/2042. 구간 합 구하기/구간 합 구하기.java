import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static long[] tree;
    static long[] arr;                 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];
        
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        build(1, 1, N);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, 1, N, b, diff);
            } else {
                sb.append(query(1, 1, N, b, (int) c)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static void build(int node, int left, int right) {
        if (left == right) {
            tree[node] = arr[left];
            return;
        }
        int mid = (left + right) / 2;
        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void update(int node, int nodeLeft, int nodeRight, int index, long diff) {
        if (index < nodeLeft || index > nodeRight) return; 

        tree[node] += diff;

        if (nodeLeft == nodeRight) return;                  

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, index, diff);
        update(node * 2 + 1, mid + 1, nodeRight, index, diff);
    }
    
    static long query(int node, int nodeLeft, int nodeRight, int left, int right) {
        if (right < nodeLeft || left > nodeRight) return 0; 
        if (left <= nodeLeft && nodeRight <= right) return tree[node]; 

        int mid = (nodeLeft + nodeRight) / 2;
        return query(node * 2, nodeLeft, mid, left, right)
                + query(node * 2 + 1, mid + 1, nodeRight, left, right);
    }
}