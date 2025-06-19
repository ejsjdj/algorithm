import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(st.nextToken());
            A[i] = data;
        }

        st = new StringTokenizer(br.readLine());
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(st.nextToken());
            B[i] = data;
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < B.length / 2; i++) {
            int tmp = B[i];
            B[i] = B[B.length - 1 - i];
            B[B.length - 1 - i] = tmp;
        }

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int value = A[i] * B[i];
            result += value;
        }

        System.out.println(result);
        br.close();
    }
}