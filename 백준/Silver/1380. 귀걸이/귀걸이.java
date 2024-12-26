import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		List<String> result = new LinkedList<>();
		while (true) {
			int N = Integer.parseInt(st.nextToken());
			if (N == 0) break;
			else {
				
				String[] names = new String[N + 1];
				boolean[] arr = new boolean[N + 1];
				
				for (int i = 1; i <= N; i++) {
					arr[i] = true;
				}
				
				for (int i = 1; i <= N; i++) {
					names[i] = bf.readLine();
				}
				while (true) {
					st = new StringTokenizer(bf.readLine());
					if (st.countTokens() == 1) break; 
					else {
						int idx = Integer.parseInt(st.nextToken());
						arr[idx] = !arr[idx];
					}
				}
					
				for (int i = 1; i < arr.length; i++) {
					if (!arr[i]) result.add(names[i]);
				}
			}
		}
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(i + 1 + " " + result.get(i));
		}
		
	}
}