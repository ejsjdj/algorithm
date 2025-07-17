import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int result = 0;
        long A[] = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                if (A[start] + A[end] == A[i]) {
                    if (start != i && end != i) {
                        result++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                }
                else if (A[start] + A[end] < A[i]) {
                    start = start + 1;
                } else if (A[start] + A[end] > A[i]) {
                    end = end - 1;
                }
            }
        }
        System.out.println(result);
    }
}