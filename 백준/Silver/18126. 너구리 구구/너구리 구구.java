import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	long value;
	HashMap<Integer, Integer> hm;
	
	public Node() {
		this.value = 0;
		hm = new HashMap<>();
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		
		Node[] nodes = new Node[N + 1];
		
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes[a].hm.put(b, c);
			nodes[b].hm.put(a, c);
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(nodes[1]);
		
		long maxLength = 0;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			HashMap<Integer,Integer> hm = now.hm;
			
			for (int key : hm.keySet()) {
				int dis = hm.get(key);
				if (nodes[key].value == 0 || nodes[key].value > now.value + dis) {
					nodes[key].value = now.value + dis;
					queue.add(nodes[key]);
				}
			}
		}
		
		for (int i = 1; i < nodes.length; i++) {
			if (maxLength < nodes[i].value) maxLength = nodes[i].value;
		}
		
		System.out.println(maxLength);
		
	}
}