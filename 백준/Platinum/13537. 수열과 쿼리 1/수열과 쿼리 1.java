import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] tree; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new int[4 * N][];

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        build(arr, 1, 1, N);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(query(1, 1, N, l, r, v)).append("\n");
        }
        System.out.print(sb);
    }

    static void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = new int[]{arr[start]};
            return;
        }

        int mid = (start + end) / 2;
        build(arr, node * 2, start, mid);
        build(arr, node * 2 + 1, mid + 1, end);

        int[] left = tree[node * 2];
        int[] right = tree[node * 2 + 1];
        tree[node] = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) tree[node][k++] = left[i++];
            else tree[node][k++] = right[j++];
        }
        while (i < left.length) tree[node][k++] = left[i++];
        while (j < right.length) tree[node][k++] = right[j++];
    }

    static int query(int node, int start, int end, int l, int r, int val) {
        if (l > end || r < start) return 0;
        if (l <= start && end <= r) {
            return tree[node].length - upperBound(tree[node], val);
        }

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, l, r, val) +
                query(node * 2 + 1, mid + 1, end, l, r, val);
    }

    static int upperBound(int[] arr, int val) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= val) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}