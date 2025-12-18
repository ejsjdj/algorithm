import java.io.*;

public class Main {
    static int count;
    
    static int recursion(String s, int l, int r) {
        count++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }
    
    static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            count = 0;
            int result = isPalindrome(s);
            bw.write(result + " " + count + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
