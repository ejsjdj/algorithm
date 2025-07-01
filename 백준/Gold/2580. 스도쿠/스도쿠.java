import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int[][] box = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(box);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(box[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean solve(int[][] board) {
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						if (isValid(board, i, j, k)) {
							board[i][j] = k;
							if (solve(board)) return true;
							board[i][j] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	static boolean isValid(int[][] board, int row, int col, int num) {
		
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == num) return false;
		}
		
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == num) return false;
		}
		
		int rowBox = row - row % 3;
		int colBox = col - col % 3;
		for (int i = rowBox; i < rowBox + 3; i++) {
			for (int j = colBox; j < colBox + 3; j++) {
				if (board[i][j] == num) return false;
			}
		}
		
		return true;
		
	}
}