import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		boolean flag;
		
		while (true) {
			str = sc.nextLine();
			if (str.equals("0")) break;
			flag = true;
			for (int i = 0; i <= str.length()/2; i++) {
				if (str.charAt(i) != str.charAt(str.length()-i-1)) {
					flag = false;
					break;
				}
			}
			if (flag) System.out.println("yes");
			else System.out.println("no");
		}
		sc.close();
	}
}