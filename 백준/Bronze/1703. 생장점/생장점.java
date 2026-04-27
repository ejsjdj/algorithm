import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			if (age == 0) {
				break;
			}
			int branch = 1;
			for (int i = 0; i < age; i++) {
				branch = branch * Integer.parseInt(st.nextToken());
				branch = branch - Integer.parseInt(st.nextToken());
			}
			System.out.println(branch);
		}
	}
}
