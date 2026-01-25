import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            int[] table = makeTable(str);
            int len = table.length;
            int patternLength = table[len - 1];
            if (patternLength == 0) {
                System.out.println(1);
                continue;
            }
            int rest = len - patternLength;
            if (len % rest == 0) System.out.println(len / rest);
            else System.out.println(1);
        }

    }

    static int[] makeTable(String pattern) {
        int patternSize = pattern.length();

        int[] table = new int[patternSize];

        int j = 0;

        for (int i = 1; i < patternSize; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j;
            }
        }

        return table;
    }

}