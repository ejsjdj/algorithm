import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println((int)(Math.pow(Math.pow(2, N) + 1, 2)));
	}

}
