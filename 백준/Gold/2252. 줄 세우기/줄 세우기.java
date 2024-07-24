import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 학생의수
		int M = sc.nextInt();	// 비교횟수
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int[] board = new int[N+1];
		
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			list.get(A).add(B);
			board[B] += 1;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < board.length; i++) {
			if (board[i] == 0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int student = queue.poll();
			System.out.print(student + " ");
			for (int i : list.get(student)) {
				board[i]--;
				if (board[i] == 0) {
					queue.add(i);
				}
			}
		}
	}
}
