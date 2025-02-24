import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int carlos = Integer.parseInt(st.nextToken());
		boolean flag = true;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int next = Integer.parseInt(st.nextToken());
			if (carlos < next) flag = false;
		}
		if (flag) System.out.println("S");
		else System.out.println("N");
		
	}
}