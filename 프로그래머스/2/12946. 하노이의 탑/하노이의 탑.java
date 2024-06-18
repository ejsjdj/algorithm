import java.util.ArrayList;

class Solution {
	ArrayList<int[]> list = new ArrayList<>();
	void hanoi(int n, int start, int mid, int aim) {
		if (n == 1) {
			list.add(new int[] {start, aim});
		}
		else {
			hanoi(n - 1, start, aim, mid);
			list.add(new int[] {start, aim});
			hanoi(n - 1, mid, start, aim);
		}
	}

	public int[][] solution(int n) {
		int start = 1;
		int mid = 2;
		int aim = 3;
		hanoi(n, start, mid, aim);
		
		int[][] arr = new int[list.size()][2];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = list.get(i)[0];
			arr[i][1] = list.get(i)[1];
		}
		
		return arr;
	}
}