import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int len = Integer.parseInt(st.nextToken());
		int scale = Integer.parseInt(st.nextToken());
		Deque<Node> deque = new LinkedList<>();
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0 ; i < len; i++) {
			int now = Integer.parseInt(st.nextToken());
			while (!deque.isEmpty() && deque.getLast().value >= now) {
				deque.removeLast();
			}
			deque.addLast(new Node(i, now));
			if (deque.getFirst().idx <= i - scale) {
				deque.removeFirst();
			}
			bw.write(deque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
		
	}
	
	static class Node {
		int idx;
		long value;
		
		Node(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	}
}