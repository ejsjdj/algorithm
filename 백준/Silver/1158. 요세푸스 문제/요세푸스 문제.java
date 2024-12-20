import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Queue<Integer> queue = new LinkedList<>();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		List<Integer> list = new ArrayList<>();
		
		int counter = 1;
		while (!queue.isEmpty()) {
			if (counter == M) {
				list.add(queue.poll());
				counter = 1;
			} else {
				queue.add(queue.poll());
				counter++;
			}
		}
		System.out.println(list.toString().replace("[", "<").replace("]", ">"));
		
		bf.close();
	}
}