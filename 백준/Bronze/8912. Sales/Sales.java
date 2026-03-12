import java.io.*;
import java.util.*;

public class Main {

    static final int MAXA = 5000;
    static int[] ft = new int[MAXA + 1];  // 1-based Fenwick Tree

    static void update(int i, int v) {
        while (i <= MAXA) {
            ft[i] += v;
            i += i & -i;
        }
    }

    static int rsq(int i) { // sum [1..i]
        int sum = 0;
        while (i > 0) {
            sum += ft[i];
            i -= i & -i;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            // Fenwick Tree 초기화
            Arrays.fill(ft, 0);

            long ans = 0;
            for (int i = 1; i <= n; i++) {
                int cnt = rsq(a[i]); // 이전 날 중 ai 이하의 개수
                ans += cnt;
                update(a[i], 1);     // 현재 값 기록
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}