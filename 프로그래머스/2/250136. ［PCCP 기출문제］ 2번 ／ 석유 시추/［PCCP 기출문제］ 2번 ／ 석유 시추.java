import java.util.Arrays;

class Solution {

	boolean[][] visited;
	boolean[] range;
	int[] result;
	int[][] move = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	int n;
	int m;
	int[][] land;

	public int solution(int[][] land) {
		int answer = 0;
		this.land = land;

		// 땅의 세로 길이
		n = land.length;
		// 땅의 가로 길이
		m = land[0].length;

		visited = new boolean[n][m];
		range = new boolean[m];
		result = new int[m];

		for (int col = 0; col < n; col++) {
			for (int row = 0; row < m; row++) {
				if (!visited[col][row] && land[col][row] == 1) {

					int result = BES(col, row);

					for (int i = 0; i < m; i++) {
						if (range[i])
							this.result[i] += result;
					}

					Arrays.fill(range, false);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			answer = Math.max(answer, this.result[i]);
		}

		return answer;
	}

	int BES(int col, int row) {

		range[row] = true;
		visited[col][row] = true;

		int result = 1;

		for (int[] move : move) {
			int newCol = col + move[0];
			int newRow = row + move[1];
			if (0 <= newCol && newCol < n && 0 <= newRow && newRow < m && !visited[newCol][newRow]
					&& land[newCol][newRow] == 1) {
				result += BES(newCol, newRow);
			}
		}

		return result;

	}
}