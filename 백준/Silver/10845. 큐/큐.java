import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		int last = -1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			String input = st.nextToken();
			if (input.equals("push")) {
				last = Integer.parseInt(st.nextToken());
				queue.add(last);
			} 
			else if (input.equals("pop")) System.out.println(queue.isEmpty() ? -1 : queue.poll());
			else if (input.equals("size")) System.out.println(queue.size());
			else if (input.equals("empty")) System.out.println(queue.isEmpty() ? 1 : 0);
			else if (input.equals("front")) System.out.println(queue.isEmpty() ? -1 : queue.peek());
			else if (input.equals("back")) System.out.println(queue.isEmpty() ? -1 : last);
		}
	}
}