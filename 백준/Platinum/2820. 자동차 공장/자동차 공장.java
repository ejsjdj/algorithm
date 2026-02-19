import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int timer = 0;
    static int[] in, out;
    static long[] fenwick; // 누적합이 int 범위를 넘을 수 있으므로 long 사용
    static List<Integer>[] adj;
    static int[] initialPay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        in = new int[N + 1];
        out = new int[N + 1];
        fenwick = new long[N + 2];
        initialPay = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        initialPay[1] = Integer.parseInt(br.readLine());
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            initialPay[i] = Integer.parseInt(st.nextToken());
            int boss = Integer.parseInt(st.nextToken());
            adj[boss].add(i);
        }

        dfs(1);

        for (int i = 1; i <= N; i++) {
            updateRange(in[i], in[i], initialPay[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            if (type.equals("p")) {
                int a = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if (in[a] < out[a]) {
                    updateRange(in[a] + 1, out[a], x);
                }
            } else {
                int a = Integer.parseInt(st.nextToken());
                sb.append(getPoint(in[a])).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    static void dfs(int curr) {
        in[curr] = ++timer;
        for (int next : adj[curr]) {
            dfs(next);
        }
        out[curr] = timer;
    }

    static void update(int idx, int val) {
        while (idx <= N) {
            fenwick[idx] += val;
            idx += (idx & -idx);
        }
    }

    static void updateRange(int left, int right, int val) {
        update(left, val);
        update(right + 1, -val);
    }

    static long getPoint(int idx) {
        long res = 0;
        while (idx > 0) {
            res += fenwick[idx];
            idx -= (idx & -idx);
        }
        return res;
    }
}