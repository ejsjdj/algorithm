import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int x = 0;
		int y = 0;
		int max = 0;
		int N = 0;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer (bf.readLine());
			for (int j = 0; j < 9; j++) {
				N = Integer.parseInt(st.nextToken());
				if (max < N) {
					max = N;
					x = i;
					y = j;
				}
			}
		}
		System.out.println(max);
		System.out.print(x + 1);
		System.out.print(" ");
		System.out.println(y + 1);
	}
}