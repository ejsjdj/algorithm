import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		int max = 0;
		int[][][] arr = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];
		
		for (int i = 0; i <= str1.length(); i++) {
			arr[i][0][0] = 0;
		}
		
		for (int i = 0; i <= str2.length(); i++) {
			arr[0][i][0] = 0;
		}
		
		for (int i = 0; i <= str3.length(); i++) {
			arr[0][0][i] = 0;
		}
		
		for (int i = 1; i < str1.length() + 1; i++) {
			for (int j = 1; j < str2.length() + 1; j++) {
				for (int k = 1; k < str3.length() + 1; k++) {
					if (str3.charAt(k - 1) == str2.charAt(j - 1) && str3.charAt(k - 1) == str1.charAt(i - 1)) {
						arr[i][j][k] = arr[i - 1][j - 1][k - 1] + 1;
						max = Math.max(arr[i][j][k], max);
					} else {
						arr[i][j][k] = Math.max(arr[i][j][k - 1], Math.max(arr[i - 1][j][k], arr[i][j - 1][k]));
					}
				}
			}
		}
		System.out.println(max);
	}
}