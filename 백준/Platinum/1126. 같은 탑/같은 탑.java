import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 0);

        for (int i = 0; i < N; i++) {
            Map<Integer, Integer> next = new HashMap<>(hm); 

            for (int diff : new ArrayList<>(hm.keySet())) {
                int high = hm.get(diff);
                int stone = arr[i];

                // 큰 쪽 더 커지는 경우
                int newdiff = diff + stone;
                int newHigh = high + stone;
                if (newHigh > next.getOrDefault(newdiff, 0)) {
                    next.put(newdiff, newHigh);
                }

                // 작은 쪽 더 커지는 경우
                newdiff = Math.abs(diff - stone);
                newHigh = Math.max(high, stone + (high - diff));
                if (newHigh > next.getOrDefault(newdiff, 0)) {
                    next.put(newdiff, newHigh);
                }
            }

            hm = next; 
        }


        System.out.println(hm.get(0) == 0 ? -1 : hm.get(0));



    }
}
