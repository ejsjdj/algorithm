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
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int K = Integer.parseInt(bf.readLine());
			if (0 < K) {
				queue.add(K);
			} else if (K == 0) {
				if (queue.isEmpty()) System.out.println(0);
				else System.out.println(queue.poll());
			}
		}
		
	}
}