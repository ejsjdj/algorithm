import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static long A;
    static long B;
    static long C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));

    }

    static long pow(long a, long b) {
        if (b == 0) return 1;
        if (b == 1) return a % C;

        long half = pow(a, b / 2);

        long result = half * half % C;

        if (b % 2 == 1) {
            return a * result % C;
        }

        return result % C;

    }

}