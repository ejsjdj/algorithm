import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int steps = 0;
        
        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
                steps++;
            } else if (B % 10 == 1) {
                B = (B - 1) / 10;
                steps++;
            } else {
                break; // No valid reverse operation
            }
        }
        
        System.out.println(B == A ? steps + 1: -1);
    }
}