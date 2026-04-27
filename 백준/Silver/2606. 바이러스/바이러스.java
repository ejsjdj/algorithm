import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int compuNum = Integer.parseInt(sc.nextLine());
		int connNum = Integer.parseInt(sc.nextLine());
		
		boolean[] visited = new boolean[compuNum+1];
		int[][] connection = new int[compuNum+1][compuNum+1];
		
		for (int i = 0; i < connNum; i++) {
			String input = sc.nextLine();
			int a = Integer.parseInt(input.split(" ")[0]);
			int b = Integer.parseInt(input.split(" ")[1]);
			connection[a][b] = 1;
			connection[b][a] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 0; i < connection.length; i++) {
				if (connection[now][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < compuNum+1; i++) {
			if (visited[i] == true) answer++; 
		}
		System.out.println(answer-1);
		sc.close();
	}
}