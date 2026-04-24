import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static long[] sumTree;
    static int[] idxTree;
    static int[] basic;
    static int idx = 0;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        sumTree = new long[N * 4];
        idxTree = new int[N * 4];
        basic = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            basic[i] = Integer.parseInt(st.nextToken());
        }

        buildSum(1, 1, N);
        buildIdx(1, 1, N);
        System.out.println(query(1, N));

    }

    static long buildSum(int node, int s, int e) {
        if (s == e) return sumTree[node] = basic[s];
        int m = (s + e) / 2;
        return sumTree[node] = buildSum(node * 2, s, m) + buildSum(node * 2 + 1, m + 1, e);
    }

    static int buildIdx(int node, int s, int e) {
        if (s == e) return idxTree[node] = s;
        int m = (s + e) / 2;
        int leftVal = buildIdx(node * 2, s, m);
        int rightVal = buildIdx(node * 2 + 1, m + 1, e);
        return idxTree[node] = (basic[leftVal] <= basic[rightVal]) ? leftVal : rightVal;
    }

    static long getSum(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (left > nodeRight || right < nodeLeft) return 0;

        if (left <= nodeLeft && nodeRight <= right) return sumTree[node];

        int mid = (nodeLeft + nodeRight) / 2;
        return getSum(left, right, node * 2, nodeLeft, mid) +
               getSum(left, right, node * 2 + 1, mid + 1, nodeRight);
    }

    static int getMinIdx(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (left > nodeRight || right < nodeLeft) return 0;
        if (left <= nodeLeft && nodeRight <= right) return idxTree[node];

        int mid = (nodeLeft + nodeRight) / 2;

        int leftVal = getMinIdx(left, right, node * 2, nodeLeft, mid);
        int rightVal = getMinIdx(left, right, node * 2 + 1, mid + 1, nodeRight);

        if (leftVal == 0) return rightVal;
        if (rightVal == 0) return leftVal;
        return (basic[leftVal] > basic[rightVal]) ? rightVal : leftVal;
    }

    static long query(int left, int right) {
        if (left > right) return 0;

        int mid = getMinIdx(left, right, 1, 1, N);
        long sum = getSum(left, right, 1, 1, N);
        long midVal = sum * basic[mid];

        long leftVal = query(left, mid - 1);
        long rightVal = query(mid + 1, right);

        return Math.max(midVal, Math.max(leftVal, rightVal));
    }

}
