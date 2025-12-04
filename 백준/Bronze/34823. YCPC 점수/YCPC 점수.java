import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long y = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());

        long maxWords = Math.min(y, Math.min(c / 2, p));

        System.out.println(maxWords);
    }
}
