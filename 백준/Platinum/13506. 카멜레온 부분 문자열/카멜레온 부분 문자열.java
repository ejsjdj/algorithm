import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] table;
    static String pattern;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pattern = br.readLine();

        table = makeTalbe(pattern);
        int n = pattern.length();

        // 중간에서 등장한 접두사 길이 기록
        boolean[] exist = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            exist[table[i]] = true;
        }

        // 전체 문자열 기준 최장 접두=접미 길이
        int len = table[n - 1];

        // 접두=접미 체인 타고 내려가며 중간에도 등장하는 길이 찾기
        while (len > 0 && !exist[len]) {
            len = table[len - 1];
        }

        if (len == 0) {
            System.out.println(-1);
        } else {
            System.out.println(pattern.substring(0, len));
        }
    }

    static int[] makeTalbe(String pattern) {
        int[] table = new int[pattern.length()];

        int j = 0;
        for (int i = 1; i < table.length; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            table[i] = j;
        }

        return table;
    }


}
