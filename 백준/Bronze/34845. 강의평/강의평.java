import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        
        long need = (long) X * N - sum;  
        
        if (need <= 0) {
            System.out.println(0);
        } else {
            int denominator = 100 - X;
            long k = (need + denominator - 1) / denominator;
            System.out.println(k);
        }
    }
}
