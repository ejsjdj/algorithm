import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int value;
	public Node(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		Node[][] arr = new Node[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = new Node(i, j, Integer.parseInt(st.nextToken()));
			}
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		boolean flag = false;
		queue.add(arr[0][0]);
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (now.value == -1) {
				flag = true;
				break;
			}
			if (now.value == 0) continue;
			if (now.x + now.value < N) queue.add(arr[now.x + now.value][now.y]);
			if (now.y + now.value < N) queue.add(arr[now.x][now.y + now.value]);
		}
		if (flag) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}
}