import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] seg;
    static int[] h;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            h = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                h[i] = Integer.parseInt(st.nextToken());
            }

            seg = new int[N * 4];
            build(1, 1, N);
            sb.append(solve(1, N)).append("\n");
        }
        System.out.println(sb);
    }

    static void build(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) seg[node] = nodeLeft;

        else {
            int mid = (nodeLeft + nodeRight) / 2;
            build(node * 2, nodeLeft, mid);
            build(node * 2 + 1, mid + 1, nodeRight);
            if (h[seg[node * 2]] < h[seg[node * 2 + 1]]) {
                seg[node] = seg[node * 2];
            } else {
                seg[node] = seg[node * 2 + 1];
            }
        }
    }

    static int query(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft > right || nodeRight < left) return -1;

        if (left <= nodeLeft && nodeRight <= right) return seg[node];

        int mid = (nodeLeft + nodeRight) / 2;

        int leftIdx = query(left, right, node * 2, nodeLeft, mid);
        int rightIdx = query(left, right, node * 2 + 1, mid + 1, nodeRight);

        if (leftIdx == -1) return rightIdx;
        if (rightIdx == -1) return leftIdx;

        if (h[leftIdx] < h[rightIdx]) return leftIdx;
        return rightIdx;
    }

    static long solve(int left, int right) {
        if (left > right) return 0;

        int idx = query(left, right, 1, 1, N);

        long resultLeft = solve(left, idx - 1);
        long resultRight = solve(idx + 1, right);

        long height = h[idx];
        long length = right - left + 1;

        long result = length * height;

        return Math.max(result, Math.max(resultLeft, resultRight));
    }

}
