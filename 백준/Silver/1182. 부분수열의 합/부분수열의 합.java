import java.io.*;
import java.util.*;

public class Main {
    static int N, S, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        dfs(0, 0, false); // idx, sum, isSelected

        System.out.println(count);
    }

    // idx: 현재 인덱스, sum: 현재까지의 합, isSelected: 최소 1개 이상 선택했는지
    static void dfs(int idx, int sum, boolean isSelected) {
        if (idx == N) {
            if (isSelected && sum == S) count++;
            return;
        }
        // 현재 원소 선택
        dfs(idx + 1, sum + arr[idx], true);
        // 현재 원소 선택 안 함
        dfs(idx + 1, sum, isSelected);
    }
}