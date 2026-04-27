import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (bf.readLine()); 
		int cnt = Integer.parseInt(st.nextToken());
		int arr[][] = new int[cnt][3];
		
		for (int i = 0; i < cnt; i ++) {
			st = new StringTokenizer (bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int arr_result[][] = new int[cnt][3];
		arr_result[0][0] = arr[0][0];
		arr_result[0][1] = arr[0][1];
		arr_result[0][2] = arr[0][2];
		
		for (int i = 1; i < cnt; i++) {
			arr_result[i][0] = arr[i][0] + Math.min(arr_result[i-1][1], arr_result[i-1][2]);
			arr_result[i][1] = arr[i][1] + Math.min(arr_result[i-1][0], arr_result[i-1][2]);
			arr_result[i][2] = arr[i][2] + Math.min(arr_result[i-1][0], arr_result[i-1][1]);
		}
		System.out.println(Math.min(arr_result[cnt-1][0], Math.min(arr_result[cnt-1][1], arr_result[cnt-1][2])));
	}

}