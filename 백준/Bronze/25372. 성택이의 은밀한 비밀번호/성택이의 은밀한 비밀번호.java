import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int len = s.length();
            
            if (len >= 6 && len <= 9) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
