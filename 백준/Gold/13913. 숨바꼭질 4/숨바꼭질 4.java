import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class T implements Comparable<T> {
	int pos;
	int step;
	
	public T(int pos, int step) {
		super();
		this.pos = pos;
		this.step = step;
	}

	@Override
	public int compareTo(T o) {
		
		return this.step - o.step;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int MAX = 100001;
		
		int[] diff = new int[MAX];
		int[] prev = new int[MAX];
		Arrays.fill(diff, Integer.MAX_VALUE / 2);
		Arrays.fill(prev, -1);
		diff[N] = 0;
		PriorityQueue<T> pq = new PriorityQueue<>();
		pq.add(new T(N, 0));
		
		while (!pq.isEmpty()) {
			T cur = pq.poll();
			
			if (cur.pos == K) break;
			
			for (int i : new int[] {cur.pos -1, cur.pos + 1, cur.pos * 2}) {
				if (i >= 0 && i < MAX) {
					if (diff[i] > cur.step + 1) {
						diff[i] = cur.step + 1;
						prev[i] = cur.pos;
						pq.add(new T(i, cur.step + 1));
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(diff[K]).append("\n");
		List<Integer> list = new ArrayList<>();
		for (int i = K; i != -1; i = prev[i]) {
			list.add(i);
		}
		Collections.reverse(list);
		for (int i : list) sb.append(i).append(" ");
		System.out.println(sb);
	}
}
