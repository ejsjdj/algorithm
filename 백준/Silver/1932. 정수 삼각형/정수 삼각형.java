import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            arr[i][0] += arr[i-1][0];
            for (int j = 1; j < i; j++) {
                arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
            }
            arr[i][i] += arr[i-1][i-1];
        }

        int max = arr[N-1][0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, arr[N-1][i]);
        }
        System.out.println(max);
    }
}