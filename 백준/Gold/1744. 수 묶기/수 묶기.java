import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int sum = 0;
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();
		
		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if (input > 0) pq1.add(input);
			else pq2.add(input);
		}
		
		while (pq2.size() >= 2) {
			sum += (pq2.poll() * pq2.poll());
		}
		while (!pq2.isEmpty()) {
			sum += pq2.poll();
		}
		while (pq1.size() >= 2) {
			int a = pq1.poll();
			int b = pq1.poll();
			if (a == 1 || b == 1) {
				sum += a + b;
			} else {
				sum += a * b;				
			}
		}
		while(!pq1.isEmpty()) {
			sum += pq1.poll();
		}
		System.out.println(sum);
		sc.close();
	}
}