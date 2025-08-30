import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static boolean[] visited;
	static List<Integer> list;
	static int[] arr;
	
	static void recur(int depth) {
		
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(arr[i]);
				recur(depth + 1);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		recur(0);
		System.out.println(sb);
	}
}