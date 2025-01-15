import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] bridges;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		bridges = new int[N + 1];
		for (int i = 0; i < bridges.length; i++) {
			bridges[i] = i;
		}
		
		for (int i = 0; i < N - 2; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		boolean flag = false;
		int left = 0;
		int right = 0;
		for (int i = 1; i < bridges.length; i++) {
			if (bridges[i] == i) {
				if (flag) {
					right = i;
					break;
				}
				else {
					flag = true;
					left = i;				
				}
			}
		}
		System.out.println(left + " " + right);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) bridges[b] = a;
	}
	
	static int find(int a) {
		if (bridges[a] == a) return a;
		else return bridges[a] = find(bridges[a]);
	}
}