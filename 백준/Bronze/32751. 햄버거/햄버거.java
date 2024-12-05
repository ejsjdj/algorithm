import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] arr = new int[4];
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 4; i++) { arr[i] = Integer.parseInt(st.nextToken()); }
		
		st = new StringTokenizer(bf.readLine());
		String str = st.nextToken();
		boolean flag = true;
		char last = ' ';
		if (str.charAt(0) != 'a' || str.charAt(str.length() - 1) != 'a') flag = false;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) != last && arr[str.charAt(i) - 'a']-- != 0) last = str.charAt(i);
			else {
				flag = false;
				break;
			}
		}
		if (flag) System.out.println("Yes");
		else System.out.println("No");
	}
}