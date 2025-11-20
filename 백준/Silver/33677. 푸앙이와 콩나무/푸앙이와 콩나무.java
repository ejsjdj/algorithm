import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N + 1][2];

        for (int i = 0; i < N + 1; i++) {
            arr[i][0] = Integer.MAX_VALUE;
            arr[i][1] = Integer.MAX_VALUE;
        }

        arr[0][0] = 0;
        arr[0][1] = 0;

        for (int i = 0; i <= N; i++) {
            if (i + 1 <= N) {
                if (arr[i][0] + 1 < arr[i + 1][0]) {
                    arr[i + 1][0] = arr[i][0] + 1;
                    arr[i + 1][1] = arr[i][1] + 1;
                } else if (arr[i][0] + 1 == arr[i + 1][0]) {
                    arr[i + 1][1] = Math.min(arr[i + 1][1], arr[i][1] + 1);
                }
            }

            if ((long)i * 3 <= N) {
                if (arr[i][0] + 1 < arr[i * 3][0]) {
                    arr[i * 3][0] = arr[i][0] + 1;
                    arr[i * 3][1] = arr[i][1] + 3;
                } else if (arr[i][0] + 1 == arr[i * 3][0]) {
                    arr[i * 3][1] = Math.min(arr[i * 3][1], arr[i][1] + 3);
                }
            }

            if ((long) i * i <= N) {
                if (arr[i][0] + 1 < arr[i * i][0]) {
                    arr[i * i][0] = arr[i][0] + 1;
                    arr[i * i][1] = arr[i][1] + 5;
                } else if (arr[i][0] + 1 == arr[i * i][0]) {
                    arr[i * i][1] = Math.min(arr[i * i][1], arr[i][1] + 5);
                }
            }
        }

        System.out.print(arr[N][0] + " ");
        System.out.println(arr[N][1]);

    }
}