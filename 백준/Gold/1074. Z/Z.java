import java.io.*;
import java.util.*;

public class Main {
    static int N, R, C, ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        solve(0, 0, (int)Math.pow(2, N));
    }

    static void solve(int r, int c, int size) {
        if(size == 1) {
            System.out.println(ans);
            return;
        }
        int newSize = size / 2;
        int cnt = (size * size) / 4;
        // 1사분면
        if(R < r + newSize && C < c + newSize) {
            solve(r, c, newSize);
        }
        // 2사분면
        else if(R < r + newSize && C >= c + newSize) {
            ans += cnt;
            solve(r, c + newSize, newSize);
        }
        // 3사분면
        else if(R >= r + newSize && C < c + newSize) {
            ans += cnt * 2;
            solve(r + newSize, c, newSize);
        }
        // 4사분면
        else {
            ans += cnt * 3;
            solve(r + newSize, c + newSize, newSize);
        }
    }
}
