import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static long[] treeMax1, treeMax2, treeSum;
    static int[] treeMaxCnt;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        treeMax1 = new long[N * 4];
        treeMax2 = new long[N * 4];
        treeSum = new long[N * 4];
        treeMaxCnt = new int[N * 4];

        st = new StringTokenizer(br.readLine());
        init(1, 1, N);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (type == 1) {
                long val = Long.parseLong(st.nextToken());
                update(left, right, 1, val, 1, N);
            } else if (type == 2) {
                sb.append(queryMax(left, right, 1, 1, N)).append("\n");
            } else {
                sb.append(querySum(left, right, 1, 1, N)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            int val = Integer.parseInt(st.nextToken());
            treeMax1[node] = val;
            treeSum[node] = val;
            treeMax2[node] = -1;
            treeMaxCnt[node] = 1;
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);
        pushUp(node);
    }

    static void pushUp(int node) {
        int leftChild = node * 2;
        int rightChild = node * 2 + 1;
        treeSum[node] = treeSum[leftChild] + treeSum[rightChild];

        if (treeMax1[leftChild] == treeMax1[rightChild]) {
            treeMax1[node] = treeMax1[leftChild];

            treeMax2[node] = Math.max(treeMax2[leftChild], treeMax2[rightChild]);
            treeMaxCnt[node] = treeMaxCnt[leftChild] + treeMaxCnt[rightChild];
        }

        else if (treeMax1[leftChild] > treeMax1[rightChild]) {
            treeMax1[node] = treeMax1[leftChild];
            treeMaxCnt[node] = treeMaxCnt[leftChild];

            treeMax2[node] = Math.max(treeMax2[leftChild], treeMax1[rightChild]);
            treeMaxCnt[node] = treeMaxCnt[leftChild];
        }

        else {
            treeMax1[node] = treeMax1[rightChild];
            treeMaxCnt[node] = treeMaxCnt[rightChild];

            treeMax2[node] = Math.max(treeMax1[leftChild], treeMax2[rightChild]);
            treeMaxCnt[node] = treeMaxCnt[rightChild];
        }
    }

    static void propagation(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) return;

        for (int child : new int[]{node * 2, node * 2 + 1}) {

            if (treeMax1[child] > treeMax1[node]) {
                treeSum[child] -= (long) treeMaxCnt[child] * (treeMax1[child] - treeMax1[node]);
                treeMax1[child] = treeMax1[node];
            }

        }
    }

    static void update(int left, int right, int node, long val, int nodeLeft, int nodeRight) {
        if (right < nodeLeft || left > nodeRight || treeMax1[node] <= val) return;

        if (left <= nodeLeft && nodeRight <= right && treeMax2[node] < val) {
            treeSum[node] -= (long) treeMaxCnt[node] * (treeMax1[node] - val);
            treeMax1[node] = val;
            return;
        }

        propagation(node, nodeLeft, nodeRight);
        int mid = (nodeLeft + nodeRight) / 2;
        update(left, right, node * 2, val, nodeLeft, mid);
        update(left, right, node * 2 + 1, val, mid + 1, nodeRight);
        pushUp(node);
    }

    static long queryMax(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (right < nodeLeft || left > nodeRight) return 0;
        if (left <= nodeLeft && nodeRight <= right) return treeMax1[node];

        propagation(node, nodeLeft, nodeRight);
        int mid = (nodeLeft + nodeRight) / 2;
        return Math.max(
                queryMax(left, right, node * 2, nodeLeft, mid),
                queryMax(left, right, node * 2 + 1, mid + 1, nodeRight)
        );
    }

    static long querySum(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (right < nodeLeft || nodeRight < left) return 0;
        if (left <= nodeLeft && nodeRight <= right) return treeSum[node];

        propagation(node, nodeLeft, nodeRight);
        int mid = (nodeLeft + nodeRight) / 2;
        return querySum(left, right, node * 2, nodeLeft, mid) +
                querySum(left, right, node * 2 + 1, mid + 1, nodeRight);


    }

}