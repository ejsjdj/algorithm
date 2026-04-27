import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int cnt = 0;
		
		while (str1.length() >= str2.length()) {
			
			String now = str1.substring(0, str2.length());
			
			if (now.equals(str2)) {
				cnt++;
				str1 = str1.substring(str2.length());
			} else str1 = str1.substring(1);
			
		}
		System.out.println(cnt);
		sc.close();
	}
}
