import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		long sum1 = 0;
		long sum2 = 0;
		
		Stack<Long> stack1 = new Stack<>();
		Stack<Long> stack2 = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long input = Long.parseLong(st.nextToken());
			stack1.push(input);
			sum1 += input;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long input = Long.parseLong(st.nextToken());
			stack2.push(input);
			sum2 += input;
		}
		
		for (int i = 0; i < L; i++) {
			if (stack1.isEmpty() && stack2.isEmpty()) break;
			if (sum1 <= sum2) {
				long num = stack2.pop();
				sum2 -= num;
			} else {
				long num = stack1.pop();
				sum1 -= num;
			}
		}
		
		System.out.println(sum1 >= sum2 ? sum1 : sum2);
	}
}
