import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int first = 0;
        int last = 0;
        int sum = 0;
        int cnt = 0;
        
        while (true) {
            if (sum >= M) {
                if (sum == M) cnt++;
                sum -= arr[first++];
            } else if (last == N) { 
                break;
            } else { 
                sum += arr[last++]; 
            }
        }
        
        if (sum == M) cnt++;
        System.out.println(cnt);
        
        bf.close();
    }
}