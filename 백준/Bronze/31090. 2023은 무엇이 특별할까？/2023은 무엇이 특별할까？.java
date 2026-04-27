import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		
		for (int i = 0; i < cnt; i ++) {
			int N = sc.nextInt();
			
			if ((N + 1) % (N % 100) == 0) System.out.println("Good");
			else System.out.println("Bye");
		}
		
		sc.close();
		
	}

}
