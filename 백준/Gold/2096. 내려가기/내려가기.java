import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		int[][] min_arr = new int[N][3];
		int[][] max_arr = new int[N][3];
		
		for (int i = 0; i < 3; i++) {
			min_arr[0][i] = arr[0][i];
			max_arr[0][i] = arr[0][i];
		}
		
		for (int i = 1; i < N; i++) {
			max_arr[i][0] = arr[i][0] + Math.max(max_arr[i - 1][0], max_arr[i - 1][1]);
			max_arr[i][1] = arr[i][1] + Math.max(max_arr[i - 1][0], Math.max(max_arr[i - 1][1], max_arr[i - 1][2]));
			max_arr[i][2] = arr[i][2] + Math.max(max_arr[i - 1][1], max_arr[i - 1][2]);
			
			min_arr[i][0] = arr[i][0] + Math.min(min_arr[i - 1][0], min_arr[i - 1][1]);
			min_arr[i][1] = arr[i][1] + Math.min(min_arr[i - 1][0], Math.min(min_arr[i - 1][1], min_arr[i - 1][2]));
			min_arr[i][2] = arr[i][2] + Math.min(min_arr[i - 1][1], min_arr[i - 1][2]);
		}
		
		System.out.print(Math.max(max_arr[N-1][0], Math.max(max_arr[N-1][1], max_arr[N-1][2])) + " ");
		System.out.println(Math.min(min_arr[N-1][0], Math.min(min_arr[N-1][1], min_arr[N-1][2])));
		
	}
}