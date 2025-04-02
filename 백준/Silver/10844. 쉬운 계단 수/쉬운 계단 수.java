import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[10][N];
		
		for (int i = 1; i < 10; i++) {
			arr[i][0] = 1;
		}
		
		for (int j = 1; j < N; j++) {
			for (int i = 0; i < 10; i++) {
				if (i == 0) arr[i][j] = arr[i + 1][j - 1] % 1000000000;
				else if (i == 9) arr[i][j] = arr[i - 1][j - 1] % 1000000000;
				else {					
					arr[i][j] += arr[i - 1][j - 1] % 1000000000;
					arr[i][j] += arr[i + 1][j - 1] % 1000000000;
				}
			}
		}
		long result = 0;
		for (int i = 0; i < 10; i++) {
			result += arr[i][N - 1];
			result %= 1000000000;
		}
		System.out.println(result);
	}
}