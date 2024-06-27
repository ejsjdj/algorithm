import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		boolean flag = false;
		for (int i = 0; i < 8; i++) {
			String str = bf.readLine();
			if (flag == false) {
				for (int j = 0; j < 8; j = j + 2) {if (str.charAt(j) == 'F') cnt++;}
			} else {
				for (int j = 1; j < 8; j = j + 2) {if (str.charAt(j) == 'F') cnt++;}
			} flag = !flag;
		}
		System.out.println(cnt);
	}
}