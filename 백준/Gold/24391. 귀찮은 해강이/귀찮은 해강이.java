import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] building;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		building = new int[N + 1];
		for (int i = 0; i < building.length; i++) building[i] = i;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		st = new StringTokenizer(bf.readLine());
		int now = Integer.parseInt(st.nextToken());
		now = find(now);
		
		for (int i = 0; i < N - 1; i++) {
			int next = Integer.parseInt(st.nextToken());
			next = find(next);
			if (now != next) {
				cnt++;
				now = next;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void union (int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) building[b] = a;
	}
	
	static int find(int a) {
		if (building[a] == a) return a;
		return building[a] = find(building[a]);
	}
	
}