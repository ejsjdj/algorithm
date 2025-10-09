import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		int[][] arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		arr = pow(arr, B);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int[][] pow(int[][] mat, long exp) {
		int N = mat.length;
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) result[i][i] = 1;
		while (exp > 0) {
			if ((exp & 1) == 1) result = multiply(result, mat);
			mat = multiply(mat,mat);
			exp >>= 1;
		}
		return result;
	}
	
	static int[][] multiply(int[][] mat1, int[][] mat2) {
		int N = mat1.length;
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					temp[i][j] += mat1[i][k] * mat2[k][j];
				} temp[i][j] %= 1000;
			}
		}
		return temp;
	}
}