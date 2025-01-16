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
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[N + 1];
		int[] subjects = new int[N + 1];
		int[] answer = new int[N + 1];
		
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			subjects[b]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i < list.length; i++) {
			if (subjects[i] == 0) {
				answer[i] = 1;
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int next : list[now]) {
				subjects[next]--;
				if (subjects[next] == 0) {
					queue.add(next);
					answer[next] = answer[now] + 1;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
	}
}