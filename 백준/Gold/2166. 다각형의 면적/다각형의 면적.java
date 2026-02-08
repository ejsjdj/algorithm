import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[] x = new long[N + 1];
        long[] y = new long[N + 1];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        
        x[N] = x[0];
        y[N] = y[0];
        
        long sumA = 0; 
        long sumB = 0; 
        
        for (int i = 0; i < N; i++) {
            sumA += x[i] * y[i + 1];
            sumB += y[i] * x[i + 1];
        }
        
        double area = Math.abs(sumA - sumB) / 2.0;
        System.out.printf("%.1f\n", area);
    }
}