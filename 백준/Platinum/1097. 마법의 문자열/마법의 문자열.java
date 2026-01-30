import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int idx = 0;
    static int N;
    static int K;

    static String[] arr;
    static List<String> list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        list = new ArrayList<>();
        int result = 0;

        makeStr("", 0);
        for (String str : list) {
            int[] table = makeTable(str);
            int L = str.length();   // 전체길이
            int pi = table[L - 1];
            int p = L - pi;         // 주기길이

            int count;
            if (L % p != 0) {
                count = 1;
            } else {
                count = L / p;
            }

            if (count == K) {
                result++;
            }
        }
        System.out.println(result);

    }

    static void makeStr(String str, int level) {
        if (level == N) {
            list.add(str);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeStr(str + arr[i], level + 1);
                visited[i] = false;
            }

        }
    }

    static int[] makeTable(String pattern) {
        int[] table = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = table[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j)) j++;
            table[i] = j;
        }
        return table;
    }

}