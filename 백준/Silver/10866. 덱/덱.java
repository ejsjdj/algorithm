import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			
			if (str.equals("push_front")) deque.addFirst(Integer.parseInt(st.nextToken()));
			else if (str.equals("push_back")) deque.addLast(Integer.parseInt(st.nextToken()));
			else {
				
				if (str.equals("pop_front")) {
					if (deque.isEmpty()) sb.append(-1);
					else sb.append(deque.removeFirst());
				}
				else if (str.equals("pop_back")) {
					if (deque.isEmpty()) sb.append(-1);
					else sb.append(deque.removeLast());
				}
				else if (str.equals("size")) {
					sb.append(deque.size());
				}
				else if (str.equals("empty")) {
					if (deque.isEmpty()) sb.append(1);
					else sb.append(0);
				}
				else if (str.equals("front")) {
					if (deque.isEmpty()) sb.append(-1);
					else sb.append(deque.getFirst());
				}
				else if (str.equals("back")) {
					if (deque.isEmpty()) sb.append(-1);
					else sb.append(deque.getLast());
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
		bf.close();
	}
}