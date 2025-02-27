import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 배열 정렬
        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < Math.min(N, 10); i++) {
        	for (int j = 0; j < Math.min(N, 10); j++) {
        		if (i == j) continue;
        		int a = arr[i];
        		int b = arr[j];

                int digits = 1;
                while (b >= digits) digits *= 10;
                int num = a * digits + b;
                if (set.contains(num)) continue;
        		pq.add(num);
        		if (pq.size() > 3) pq.poll();
        	}
        }
        System.out.println(pq.poll());
    }
}