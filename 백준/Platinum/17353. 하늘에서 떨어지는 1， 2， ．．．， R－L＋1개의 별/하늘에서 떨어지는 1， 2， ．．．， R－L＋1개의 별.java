import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static int start = 1;
    static long[] lazyA, lazyB;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        while (start < N) start *= 2;

        lazyA = new long[start * 2];
        lazyB = new long[start * 2];
        arr = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                update(left, right, 1, 1 - left, 1, 0, start - 1);
            } else {
                int x = Integer.parseInt(st.nextToken());
                long addedVal = query(x, 1, 0, start - 1);
                sb.append(arr[x] + addedVal).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void push(int node, int nodeLeft, int nodeRight) {
        if (lazyA[node] == 0 && lazyB[node] == 0) return;

        if (nodeLeft != nodeRight) {
            lazyA[node * 2] += lazyA[node];
            lazyB[node * 2] += lazyB[node];

            lazyA[node * 2 + 1] += lazyA[node];
            lazyB[node * 2 + 1] += lazyB[node];
        }

        lazyA[node] = 0;
        lazyB[node] = 0;
    }

    static void update(int left, int right, long valA, long valB, int node, int nodeLeft, int nodeRight) {

        if (right < nodeLeft || nodeRight < left) return;

        if (left <= nodeLeft && nodeRight <= right) {
            lazyA[node] += valA;
            lazyB[node] += valB;
            return;
        }

        push(node, nodeLeft, nodeRight);

        int mid = (nodeLeft + nodeRight) / 2;
        update(left, right, valA, valB, node * 2, nodeLeft, mid);
        update(left, right, valA, valB, node * 2 + 1, mid + 1, nodeRight);
    }

    static long query(int x, int node, int nodeLeft, int nodeRight) {
        long currentVal = lazyA[node] * x + lazyB[node];

        if (nodeLeft == nodeRight) {
            return currentVal;
        }


        int mid = (nodeLeft + nodeRight) / 2;
        if (x <= mid) {
            return currentVal + query(x, node * 2, nodeLeft, mid);
        } else {
            return currentVal + query(x, node * 2 + 1, mid + 1, nodeRight);
        }
    }
}