import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int answer = 0;
		int N = Integer.parseInt(st.nextToken());
		int left = 0;
		int right = 0;
		int sum = 0;
		while (right <= N) {
			if (sum < N) {
				right++;
				sum += right;
			} else if (sum > N) {
				sum -= left;
				left ++;
			} else if (sum == N) {
				answer++;
				right++;
				sum += right;
			}
		}
		System.out.println(answer);
	}
}