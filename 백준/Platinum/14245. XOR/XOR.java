import java.io.*;
import java.util.*;

public class Main {
    static class BIT {
        int[] tree;
        int n;
        BIT(int n) {
            this.n = n + 2;
            tree = new int[this.n];
        }
        void add(int idx, int val) {
            idx++;
            while (idx < n) {
                tree[idx] ^= val;
                idx += idx & -idx;
            }
        }
        int sum(int idx) {
            idx++;
            int res = 0;
            while (idx > 0) {
                res ^= tree[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        BIT bit = new BIT(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                bit.add(L, x);
                bit.add(R + 1, x);
            } else {
                int a = Integer.parseInt(st.nextToken());
                int res = arr[a] ^ bit.sum(a);
                System.out.println(res);
            }
        }
    }
}