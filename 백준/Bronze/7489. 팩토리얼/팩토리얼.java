import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;

                while (result % 10 == 0) result /= 10;

                result %= 1000000;
            }
            System.out.println(result % 10);
        }
    }
}