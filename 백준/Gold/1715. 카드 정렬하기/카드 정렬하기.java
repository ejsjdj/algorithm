import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(bf.readLine()));
		}
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while (pq.size() != 1) {
			data1 = pq.poll();
			data2 = pq.poll();
			sum += data1 + data2;
			pq.add(data1 + data2);
		}
		System.out.println(sum);	
	}
}