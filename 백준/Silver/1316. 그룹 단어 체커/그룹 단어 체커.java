import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		int forNum = sc.nextInt();
		
		int cnt = forNum;
		
		for (int i = 0; i < forNum; i++) {
			String str = sc.next();
			
			for (int j = 0; j < str.length() - 1; j++) {
				if (str.charAt(j) != str.charAt(j + 1)) {
					for (int k = j + 1; k < str.length(); k++) {
						if (str.charAt(j) == str.charAt(k)) {
							cnt -= 1;
							j = str.length();
							break;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}