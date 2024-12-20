import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> hm1 = new HashMap<>();
		HashMap<String, Integer> hm2 = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			String name = st.nextToken();
			hm1.put(i, name);
			hm2.put(name, i);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			String input = st.nextToken();
			
			try {
				int index = Integer.parseInt(input);
				System.out.println(hm1.get(index));
			} catch (NumberFormatException e) {
				System.out.println(hm2.get(input));
			}
		}
		bf.close();
	}
}