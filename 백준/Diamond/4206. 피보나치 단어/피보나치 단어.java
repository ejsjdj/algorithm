import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    static int[] table;
    static int patternSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String line;
        int caseCnt = 0;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String pattern = br.readLine();
            if (n < 0) break;

            caseCnt++;

            patternSize = pattern.length();
            if (patternSize == 0) {
                System.out.println(0);
                continue;
            }

            String n_2 = "0";
            String n_1 = "1";
            table = null;

            long cnt_2 = KMP(n_2, pattern);
            long cnt_1 = KMP(n_1, pattern);

            // n이 0 또는 1일 때 바로 리턴
            if (n == 0) {
                System.out.println("Case " + caseCnt + ": " + cnt_2);
                continue;
            }
            if (n == 1) {
                System.out.println("Case " + caseCnt + ": " + cnt_1);
                continue;
            }

            String pre_2 = prefix(n_2);
            String post_2 = postfix(n_2);
            String pre_1 = prefix(n_1);
            String post_1 = postfix(n_1);
            long cnt = 0;
            for (int k = 2; k <= n; k++) {
//                System.out.print(pre_1 +" " + post_2 + " ");
                cnt = cnt_1 + cnt_2 + KMP(post_1 + pre_2, pattern);
//                System.out.println(k + " 번째" + cnt);

                String n_pre  = prefix(pre_1 + pre_2);
                String n_post = postfix(post_1 + post_2);

                pre_2 = pre_1;
                post_2 = post_1;
                pre_1 = n_pre;
                post_1 = n_post;

                cnt_2 = cnt_1;
                cnt_1 = cnt;
            }

            System.out.println("Case " + caseCnt + ": " + cnt);
        }
    }

    static String prefix(String str) {
        if (str.length() < patternSize) return str;
        else return str.substring(0, patternSize - 1);
    }

    static String postfix(String str) {
        if (str.length() < patternSize) return str;
        else return str.substring(1 + str.length() - patternSize, str.length());
    }

    static int KMP(String parent, String pattern) {
        if (table == null) {
            table = makeTable(pattern);
        }

        int parentSize = parent.length();
        int cnt = 0;
        int j = 0;

        for (int i = 0; i < parentSize; i++) {
            while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (parent.charAt(i) == pattern.charAt(j)) {
                if (j == patternSize - 1) {
                    cnt++;
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
        return cnt;
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
