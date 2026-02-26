import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int timer = 0;
    static int[] in, out;
    static long[] fenwick;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        in = new int[N + 1];
        out = new int[N + 1];
        fenwick = new long[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) adj[parent].add(i);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());;

            if (type == 1) {
                // i 번째 직원이 직속 상사로부터 w 만큼 칭잔을 받는다.
                int i = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                updateRange(in[i], out[i], w);
            }
            else {
                // i 번째 직원이 칭찬을 받은 정로를 출력한다.
                int i = Integer.parseInt(st.nextToken());
                sb.append(getPoint(in[i])).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int i) {
        in[i] = ++timer;
        for (int next : adj[i]) {
            dfs(next);
        }
        out[i] = timer;
    }

    static void updateRange(int left, int right, int val) {
        update(left, val);
        update(right + 1, -val);
    }

    static void update(int idx, int val) {
        while (idx <= N) {
            fenwick[idx] += val;
            idx += (idx & -idx);
        }
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
