import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		String result = "";
		
		for (int i = 0; i < str2.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < str1.length(); j++) {
				if (str1.charAt(j) == str2.charAt(i)) flag = true;
				if (flag) break;
			}
			if (!flag) {				
				result += str2.charAt(i);
			}
		}
		
		System.out.println(result);
	}
}