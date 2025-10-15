import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	List<int[]> list = new ArrayList<>();

}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		int[] cnt = new int[N + 1];
		int[] indegree = new int[N + 1];
		Node[] nodes = new Node[N + 1];
		List<Integer> basic = new ArrayList<>();
		cnt[N] = 1;

		for (int i = 1; i < N + 1; i++) {
			nodes[i] = new Node();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // a 부품을 만드는데 필요한
			int b = Integer.parseInt(st.nextToken()); // b 부품의
			int c = Integer.parseInt(st.nextToken()); // c 개수

			nodes[a].list.add(new int[] { b, c });

			indegree[b]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (nodes[i].list.isEmpty()) basic.add(i);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		while (!queue.isEmpty()) {
			int idx = queue.poll();
			Node node = nodes[idx];

			for (int[] i : node.list) {
				int b = i[0];
				int c = i[1];

				indegree[b]--;
				if (indegree[b] == 0)
					queue.add(b);
				cnt[b] += cnt[idx] * c;
			}
		}

		for (int i : basic) {
			System.out.println(i + " " + cnt[i]);
		}
	}
}