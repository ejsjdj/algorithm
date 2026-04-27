import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		// U : 85, D : 68, P : 80, C : 67
		int U = 0;
		int D = 0;
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case 85 : 
			case 67 :
				U += 1;
				continue;
			case 68 :
			case 80 :
				D += 1;
				continue;
			}
		}
		if (U == str.length()) System.out.println("U");
		else if (str.length() == 0) System.out.println("C");
		else if (D >= 2*U-1) System.out.println("DP");
		else System.out.println("UDP");
		sc.close();
	}

}