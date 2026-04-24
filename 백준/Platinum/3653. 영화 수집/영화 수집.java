import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, M;
    static int[] idx;      
    static int[] fenwick;  
    static int size;       

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            size = N + M;
            idx = new int[N + 1];
            fenwick = new int[size + 1];

            
            for (int i = 1; i <= N; i++) {
                idx[i] = M + i;
                update(idx[i], 1);
            }

            int top = M;

            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < M; i++) {
                int x = Integer.parseInt(st.nextToken());

                int p = idx[x];
                int above = (int) sum(p - 1);
                sb.append(above).append(' ');
                
                update(p, -1);
                
                update(top, +1);
                idx[x] = top;
                top--;
            }

            out.append(sb.toString().trim()).append('\n');
        }

        System.out.print(out);
    }

    static void update(int i, int v) {
        while (i <= size) {      
            fenwick[i] += v;
            i += (i & -i);
        }
    }

    static long sum(int i) {
        long res = 0;
        while (i > 0) {
            res += fenwick[i];
            i -= (i & -i);
        }
        return res;
    }
}