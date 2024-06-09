import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int L = Integer.parseInt(st.nextToken());
		int[] aim = new int[L];
		int N = 1;
		boolean flag = true;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(bf.readLine());
			aim[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < L; i++) {
			int K = aim[i];

			if (K >= N) {
				while (K >= N) {
					stack.push(N);
					N++;
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else {
				if (stack.isEmpty()) {
					System.out.println("NO");
					flag = false;
					break;
				} else if (stack.peek() == K) {
					stack.pop();
					sb.append("-\n");
				} else if (stack.peek() > K) {
					System.out.println("NO");
					flag = false;
					break;
				}
			}
		}
		if (flag)
			System.out.println(sb.toString());
		bf.close();
	}
}