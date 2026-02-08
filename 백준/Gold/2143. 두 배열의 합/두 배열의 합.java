import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Map<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            long sum = 0;
            for (int j = i; j < arr1.length; j++) {
                sum += arr1[j];
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        long cnt = 0;
        for (int i = 0; i < arr2.length; i++) {
            long sum = 0;
            for (int j = i; j < arr2.length; j++) {
                sum += arr2[j];
                long target = T - sum;
                cnt += hm.getOrDefault(target, 0);
            }
        }
        System.out.println(cnt);

    }

}