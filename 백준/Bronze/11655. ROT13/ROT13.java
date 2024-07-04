import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String newString = "";
		
		for (int i = 0; i < str.length(); i++) {
			char aim = str.charAt(i);
			if ('a' <= aim && aim <= 'z') {
				aim = (char)('a' + (aim - 'a' + 13) % 26);
			} 
			else if ('A' <= aim && aim <= 'Z') {
				aim = (char)('A' + (aim - 'A' + 13) % 26);
			}
			newString += aim;
		}
		
		System.out.println(newString);
		sc.close();
	}
}
