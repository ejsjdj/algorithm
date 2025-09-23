import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			
			input %= 25;
			
			if (input < 17) System.out.println("ONLINE");
			else System.out.println("OFFLINE");
		}
		
	}
}