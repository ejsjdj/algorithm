import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];
        Map<Integer, Integer> hm = new HashMap<>();
        tree = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            hm.put(Integer.parseInt(st.nextToken()), i);
        }

        long result = 0;
        for (int i = 1; i <= N; i++) {
            long sum = sum(N) - sum(hm.get(A[i]));

            result += sum;

            update(hm.get(A[i]));
        }

        System.out.println(result);
    }

    static void update(int index) {
        while (index <= N) {
            tree[index] += 1;
            index += (index & -index);
        }
    }

    static long sum(int index) {
        long result = 0;
        while (index > 0) {
            result += tree[index];
            index -= (index & -index);
        }
        return result;
    }

}
