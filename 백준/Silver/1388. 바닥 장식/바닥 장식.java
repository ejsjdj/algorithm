import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] word = sc.nextLine().split(" ");
		
		int n = Integer.parseInt(word[0]);
		int m = Integer.parseInt(word[1]);
		int answer = n*m;
		
		char[][] board = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String tile = sc.nextLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = tile.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 1; j++) {
				if (board[i][j] == '-' && board[i][j+1] == '-') answer -= 1;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (board[j][i] == '|' && board[j+1][i] == '|') answer -= 1;
			}
		}
		
		
		System.out.println(answer);
		
	}
}