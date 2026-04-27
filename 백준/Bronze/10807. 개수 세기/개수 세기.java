import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (bf.readLine());
		int arr[] = new int[Integer.parseInt(st.nextToken())];
		st = new StringTokenizer (bf.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer (bf.readLine());
		int target = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) cnt++;
		}
		System.out.println(cnt);
		bf.close();
	}
}
