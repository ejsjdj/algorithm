import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        while (start < MAX) start <<= 1;

        long[] tree = new long[start * 2];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());

            if (A == 2) {
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                update(tree, start, B, C);
            } else {
                int k = Integer.parseInt(st.nextToken());
                int taste = kth(tree, start, k);
                sb.append(taste).append('\n');
                update(tree, start, taste, -1);
            }
        }

        System.out.print(sb.toString());
    }

    static void update(long[] tree, int start, int taste, long diff) {
        int idx = start + (taste - 1);
        tree[idx] += diff;
        idx >>= 1;
        while (idx > 0) {
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
            idx >>= 1;
        }
    }

    static int kth(long[] tree, int start, long k) {
        int node = 1;
        while (node < start) {
            long left = tree[node * 2];
            if (k <= left) node = node * 2;
            else {
                k -= left;
                node = node * 2 + 1;
            }
        }
        return (node - start) + 1;
    }
}