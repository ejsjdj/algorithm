import java.util.Arrays;

class Solution {
	public int solution(int a, int b, int c, int d) {
		int answer = 0;
		int[] arr = new int[4];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		arr[3] = d;
		Arrays.sort(arr);
		int p = arr[0];
		int q = arr[3];

		if (a == b && b == c && c == d) { // 모두 같을때
			answer = a * 1111;
		} else if (arr[0] == arr[1] && arr[1] == arr[2]) { // 3개가 같을때
			answer = (10 * arr[0] + arr[3]) * (10 * arr[0] + arr[3]);
		} else if (arr[1] == arr[2] && arr[2] == arr[3]) {
			answer = (10 * arr[3] + arr[0]) * (10 * arr[3] + arr[0]);
		} else if (arr[0] == arr[1] && arr[2] == arr[3]) { // 2개씩 같을때
			answer = (arr[0] + arr[3]) * (int) Math.abs(arr[0] - arr[3]);
		} else if (arr[0] == arr[1]) {
			answer = arr[2] * arr[3]; // 2개가 같고 나머지가 다를대
		} else if (arr[1] == arr[2]) {
			answer = arr[0] * arr[3];
		} else if (arr[2] == arr[3]) {
			answer = arr[0] * arr[1];
		} else

		{ // 모두 다를때
			answer = Math.min(a, Math.min(b, Math.min(c, d)));
		}
		return answer;

	}
}