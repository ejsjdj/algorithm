import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long arr[] = new long[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		long arr2[] = new long[M];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(arr2[i], arr));
		}	
	}
	
	static int binarySearch(long key, long search_arr[]) {
		
		int start = 0;
		int end = search_arr.length;
		
		while (end-start > 0) {
			if (search_arr[(start + end) / 2] == key) {
				return 1;
			}
			else if (search_arr[(start + end) / 2] > key) {
				end = (start + end) / 2;
			}
			else if (search_arr[(start + end) / 2] < key) {
				start = (start + end) / 2 + 1;
			}
		}
		return 0;
	}
}