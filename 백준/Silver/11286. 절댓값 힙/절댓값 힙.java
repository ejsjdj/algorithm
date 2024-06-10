import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> pqueue = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if (first_abs == second_abs) return o1 > o2 ? 1 : -1;
			else return first_abs - second_abs;
		});
		
		for (int i = 0; i < len; i++) {
			int request = Integer.parseInt(bf.readLine());
			if (request == 0) {
				if (pqueue.isEmpty()) System.out.println(0);
				else {
					System.out.println(pqueue.poll());
				}
			} else {
				pqueue.add(request);
			}
		}
	}
}