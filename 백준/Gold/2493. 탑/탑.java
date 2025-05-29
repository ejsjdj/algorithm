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
		int[] arr = new int[N];
		Stack<Integer> tower = new Stack<>();
		Stack<Integer> idx = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			while (!tower.isEmpty() && tower.peek() < now) {
				tower.pop();
				idx.pop();
			}
			
			if (!tower.isEmpty()) {
				arr[i] = idx.peek() + 1; 
			} else {
				arr[i] = 0;
			}
			
			tower.push(now);
			idx.push(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
		
		
	}
}