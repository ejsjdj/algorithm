import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] reverse = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            reverse[n - 1 - i] = arr[i];
        }

        int MAXVALUE = -1;

        int[] table = makeTable(reverse);
        int len = 0;
        for (int i = 1; i < n; i++) {
            if (MAXVALUE < table[i]) {
                MAXVALUE = table[i];
                len = 1;
            } else if (MAXVALUE == table[i]) {
                len++;
            }
        }
        if (MAXVALUE == 0) {
            System.out.println("-1");
        } else {
            System.out.println(MAXVALUE + " " + len);
        }
    }

    static int[] makeTable(int[] pattern) {
        int[] table = new int[pattern.length];
        int j = 0;
        int cnt = -1;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = table[j-1];
            }
            if (pattern[i] == pattern[j]) {
                table[i] = ++j;
                cnt = j;
            }
        }
        return table;
    }
}