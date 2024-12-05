import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		String[] arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = st.nextToken();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			String now = st.nextToken();
			for (int j = 0; j < N; j++) {
				if (now.equals(arr[j])) {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}