import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[3];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		arr[1] = Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		while (arr[2] != 0) {
			if (arr[2] >= arr[0] + arr[1]) System.out.println("Invalid");
			else if (arr[0] == arr[1] && arr[1] == arr[2]) System.out.println("Equilateral");
			else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0]) System.out.println("Isosceles");
			else System.out.println("Scalene");
			
			st = new StringTokenizer(bf.readLine());
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());

			Arrays.sort(arr);
		} 
	}
}