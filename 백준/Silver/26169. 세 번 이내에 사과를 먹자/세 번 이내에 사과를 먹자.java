import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int row;
	int col;
	int value; 
	public Node(int col, int row, int value) {
		this.col = col;
		this.row = row;
		this.value = value;
	}
}

public class Main {
	static boolean flag;
	static boolean[][] visited = new boolean[5][5];
	static Node[][] arr = new Node[5][5];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = new Node(j, i, Integer.parseInt(st.nextToken()));
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		BFS(row, col, 0, 0);
		
		if (flag) System.out.println(1);
		else System.out.println(0);
	}
	
	static void BFS(int row, int col, int cnt, int step) {
		visited[row][col] = true;
		
		if (arr[row][col].value == 1) {
			cnt += 1;
		}
		if (cnt == 2) flag = true;
		else if (step == 3) {
			
		}
		else {			
			if (row >= 1 && !visited[row - 1][col] && arr[row-1][col].value != -1) {
				BFS(row-1, col, cnt, step + 1);
			}
			if (row <= 3 && !visited[row + 1][col] && arr[row + 1][col].value != -1) {
				BFS(row + 1, col, cnt, step + 1);
			}
			if (col >= 1 && !visited[row][col - 1] && arr[row][col - 1].value != -1) {
				BFS(row, col - 1, cnt, step + 1);
			}
			if (col <= 3 && !visited[row][col + 1] && arr[row][col + 1].value != -1) {
				BFS(row, col + 1, cnt, step + 1);
			}
		}
		
		visited[row][col] = false;
	}
}