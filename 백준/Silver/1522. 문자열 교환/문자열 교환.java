import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int aCnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') aCnt++;
		}
		
		str = str + str;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < str.length() - aCnt; i++) {
			int bCnt = 0;
			for (int j = i; j < i + aCnt; j++) {
				if (str.charAt(j) == 'b') bCnt++;
			}
			min = Math.min(bCnt, min);
		}
		
		System.out.println(min);
	}
}
