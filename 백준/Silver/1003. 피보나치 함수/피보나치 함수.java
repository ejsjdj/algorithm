import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1 0
//0 1
//1 1
//1 2
//2 3
//3 5
//5 8
//8 13
//13 21
//21 34
//34 55
//55 89
//89 144
//144 233

public class Main {
	static int[] A = new int[42];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		A[0] = 1;
		A[1] = 0;
		A[2] = 1;
		
		for (int i = 3; i < 42; i++) {
			A[i] = A[i-1] + A[i-2];
		}
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());
			System.out.printf("%d %d\n", A[k], A[k+1]);
		}
		bf.close();
	}
}