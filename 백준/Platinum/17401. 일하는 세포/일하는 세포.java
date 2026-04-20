import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static long D;
    static final long MOD = 1_000_000_007L;
    static int MAX_LOG = 31; // 2^30 > 1e9 이므로 충분

    static int[][][] bin;
    static int[][] tmp;

    static int[][] mult(int[][] a, int[][] b) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (a[i][k] == 0) continue;
                long aik = a[i][k];
                for (int j = 0; j < N; j++) {
                    if (b[k][j] == 0) continue;
                    res[i][j] = (int) ((res[i][j] + aik * b[k][j]) % MOD);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        D = Long.parseLong(st.nextToken());

        int[][] cycle = new int[N][N];
        int[][] res = new int[N][N];
        int[][] remain = new int[N][N];

        for (int i = 0; i < N; i++) {
            cycle[i][i] = 1;
            res[i][i] = 1;
            remain[i][i] = 1;
        }

        tmp = new int[N][N];

        long fullCycles = D / T;
        int rest = (int) (D % T);

        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tmp[i][j] = 0;
                }
            }

            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int w = Integer.parseInt(st.nextToken());
                tmp[from][to] = w;
            }

            cycle = mult(cycle, tmp);

            if (t < rest) {
                remain = mult(remain, tmp);
            }
        }

        if (fullCycles > 0) {
            bin = new int[MAX_LOG][N][N];
            bin[0] = cycle;
            for (int i = 1; i < MAX_LOG; i++) {
                bin[i] = mult(bin[i - 1], bin[i - 1]);
            }

            long p = fullCycles;
            for (int i = 0; i < MAX_LOG; i++) {
                if (((p >> i) & 1L) == 1L) {
                    res = mult(res, bin[i]);
                }
            }
        }

        res = mult(res, remain);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}