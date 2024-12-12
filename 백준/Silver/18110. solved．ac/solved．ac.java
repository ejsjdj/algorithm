import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine().trim());
        }
        
        Arrays.sort(arr);
        
        int cuttingPoint = Math.round(N * 15.0f / 100.0f);
        int sum = 0;
        
        for (int i = cuttingPoint; i < N - cuttingPoint; i++) {
            sum += arr[i];
        }
        
        System.out.println(Math.round((float)sum / (N - cuttingPoint * 2)));
        
        bf.close();
    }
}