import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer (bf.readLine());
			int startPoint = Integer.parseInt(st.nextToken());
			int endPoint = Integer.parseInt(st.nextToken());
			int ballNum = Integer.parseInt(st.nextToken());
			for (int j = startPoint-1; j < endPoint; j++) {
				arr[j] = ballNum;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
