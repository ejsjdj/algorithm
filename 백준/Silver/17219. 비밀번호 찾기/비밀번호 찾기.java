import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String address = st.nextToken();
			String password = st.nextToken();
			hm.put(address, password);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String data = br.readLine();
			sb.append(hm.get(data)).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}