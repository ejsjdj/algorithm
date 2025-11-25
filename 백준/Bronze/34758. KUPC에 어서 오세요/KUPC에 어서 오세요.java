import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());  // nextInt() → nextToken()
        int y = Integer.parseInt(st.nextToken());  // nextInt() → nextToken()
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  // nextInt() → nextToken()
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // nextInt() → nextToken()
            int b = Integer.parseInt(st.nextToken());  // nextInt() → nextToken()
            if (a == x || b == y) System.out.println(0);
            else System.out.println(1);
        }
    }
}
