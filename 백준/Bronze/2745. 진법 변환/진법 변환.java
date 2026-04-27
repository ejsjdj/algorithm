import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String num = sc.next();
		int arithmetic = sc.nextInt();
		int result = 0;
		for (int i = 0; i < num.length(); i ++) {
			if (48 <= num.charAt(i) && num.charAt(i) <= 57) result = result * arithmetic + num.charAt(i) - 48;
			else if (65 <= num.charAt(i) && num.charAt(i) <= 90)  result = result * arithmetic + num.charAt(i) - 55;
		}
		System.out.println(result);
	}

}
