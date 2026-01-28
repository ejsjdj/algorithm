import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        int[] pi = makeTable(s);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int L = i + 1;
            int p = pi[i];

            if (p == 0) continue;

            int repeat = L - p;
            if (L % repeat == 0 && L / repeat >= 2) {
                sb.append(L).append(" ").append(L / repeat).append("\n");
            }
        }

        System.out.print(sb);
    }

    static int[] makeTable(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                pi[i] = j;
            }
        }
        return pi;
    }
}