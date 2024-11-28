import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int cnt = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[21];
		
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(bf.readLine());
			String order = st.nextToken();
			
			switch (order) {
			
			case "add" :
				arr[Integer.parseInt(st.nextToken())] = true;
				break;
				
			case "remove" :
				arr[Integer.parseInt(st.nextToken())] = false;
				break;
				
			case "check" :
				sb.append(arr[Integer.parseInt(st.nextToken())] ? 1 : 0);
				sb.append('\n');
				break;
				
			case "toggle" :
				int idx = Integer.parseInt(st.nextToken());
				arr[idx] = !arr[idx];
				break;
				
			case "all" :
				for (int j = 0; j < arr.length; j++) arr[j] = true;
				break;
				
			case "empty" :
				for (int j = 1; j < arr.length; j++) arr[j] = false;
				break;
			}
		}
		System.out.println(sb);
		bf.close();
	}
}