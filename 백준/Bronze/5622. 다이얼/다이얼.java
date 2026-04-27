import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		sc.close();
		
		int sum = 0;
		
		for (int i = 0; i < str1.length(); i++) {
			sum += cnt(d(str1.substring(i, i+1)));
		}
		System.out.println(sum);

	}
	public static int d(String str) {
		if (str.equals("A")) {
			return 2;
		} else if (str.equals("B")) {
			return 2;
		} else if (str.equals("C")) {
			return 2;
		} else if (str.equals("D")) {
			return 3;
		} else if (str.equals("E")) {
			return 3;
		} else if (str.equals("F")) {
			return 3;
		} else if (str.equals("G")) {
			return 4;
		} else if (str.equals("H")) {
			return 4;
		} else if (str.equals("I")) {
			return 4;
		} else if (str.equals("J")) {
			return 5;
		} else if (str.equals("K")) {
			return 5;
		} else if (str.equals("L")) {
			return 5;
		} else if (str.equals("M")) {
			return 6;
		} else if (str.equals("N")) {
			return 6;
		} else if (str.equals("O")) {
			return 6;
		} else if (str.equals("P")) {
			return 7;
		} else if (str.equals("Q")) {
			return 7;
		} else if (str.equals("R")) {
			return 7;
		} else if (str.equals("S")) {
			return 7;
		} else if (str.equals("T")) {
			return 8;
		} else if (str.equals("U")) {
			return 8;
		} else if (str.equals("V")) {
			return 8;
		} else {
			return 9;
		} 
	}
	public static int cnt (int num) {
		if (num == 1) {
			return 2;
		} else if(num == 2) {
			return 3;
		} else if(num == 3) {
			return 4;
		} else if(num == 4) {
			return 5;
		} else if(num == 5) {
			return 6;
		} else if(num == 6) {
			return 7;
		} else if(num == 7) {
			return 8;
		} else if(num == 8) {
			return 9;
		} else {
			return 10;
		}
	}
}