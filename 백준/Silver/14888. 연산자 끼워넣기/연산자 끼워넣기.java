import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long max;
    static long min;

    static int level;
    static int add;
    static int sub;
    static int multi;
    static int div;

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        multi = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());

        // 초기화
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        level = N - 1;

        dp(arr[0], 0, 0, 0, 0, 0);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dp(long value, int currentLevel, int addCount, int subCount, int multiCount, int divCount) {

        // 종료 조건
        if (currentLevel == level) {
            max = Math.max(value, max);
            min = Math.min(value, min);
            return;
        }

        // 다음 숫자
        int nextNum = arr[currentLevel + 1];

        if (addCount < add) {
            dp(value + nextNum, currentLevel + 1, addCount + 1, subCount, multiCount, divCount);
        }

        if (subCount < sub) {
            dp(value - nextNum, currentLevel + 1, addCount, subCount + 1, multiCount, divCount);
        }

        if (multiCount < multi) {
            dp(value * nextNum, currentLevel + 1, addCount, subCount, multiCount + 1, divCount);
        }

        if (divCount < div) {
            dp(value / nextNum, currentLevel + 1, addCount, subCount, multiCount, divCount + 1);
        }
    }

}