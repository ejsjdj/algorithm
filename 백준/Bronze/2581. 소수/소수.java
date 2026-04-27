import java.util.Scanner;

public class Main {
	static boolean isPrime(int num) {
		if (num == 1) return false;
		if (num == 2) return true;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int sum = 0;
		int min = -1;
		
		for (int i = M; i <= N; i++) {
			if (isPrime(i)) {
				sum += i;
				if (min == -1) {
					min = i; 
				}
			}
		}
		
		if (min != -1) {
			System.out.println(sum);
			System.out.println(min);			
		} else System.out.println(-1);
		sc.close();
	}
}