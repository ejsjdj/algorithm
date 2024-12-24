import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			pq.add(num);
		}
		
		for (int i = 0; i < N; i++) {
			int num = pq.poll();
			int currentValue = num * (pq.size() + 1);
			if (max < currentValue) max = currentValue;
		}
		
		System.out.println(max);
	}
}