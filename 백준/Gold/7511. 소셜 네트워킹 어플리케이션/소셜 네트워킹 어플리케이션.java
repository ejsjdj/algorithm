import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] relation;
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int friends = Integer.parseInt(st.nextToken());
			relation = new int[friends];
			
			for (int j = 0; j < relation.length; j++) {
				relation[j] = j;
			}
			
			st = new StringTokenizer(bf.readLine());
			int connection = Integer.parseInt(st.nextToken());
			for (int j = 0; j < connection; j++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			st = new StringTokenizer(bf.readLine());
			int question = Integer.parseInt(st.nextToken());
			sb.append("Scenario " + (i + 1)  + ":\n");
			for (int j = 0; j < question; j++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (find(a) == find(b)) sb.append("1\n");
				else sb.append("0\n");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		bf.close();
		
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			relation[b] = a;
		}
	}
	
	static int find(int a) {
		if (relation[a] == a) return a;
		return relation[a] = find(relation[a]);
	}
}