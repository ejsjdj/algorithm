import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		LinkedList<Integer> deque = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			int targetIndex = deque.indexOf(target);
			
			if (targetIndex <= deque.size() / 2) {
				while (deque.getFirst() != target) {
					deque.addLast(deque.removeFirst());
					cnt++;
				}
			} else {
				while (deque.getFirst() != target) {
					deque.addFirst(deque.removeLast());
					cnt++;
				}
			}
			deque.removeFirst();
		}
		System.out.println(cnt);
	}
}