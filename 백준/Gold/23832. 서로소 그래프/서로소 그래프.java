import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] eulerPi = new int[50001];
		for (int i = 0; i < eulerPi.length; i++) {
			eulerPi[i] = i;
		}
		
		for (int i = 2; i < eulerPi.length; i++) {
			if (eulerPi[i] == i) {
				for (int j = i; j < eulerPi.length; j = j + i) {
					eulerPi[j] -= eulerPi[j] / i;
				}
			}
		}
		
		int N = sc.nextInt();
		int sum = 0;
		for (int i = 2; i <= N; i++) {
			sum += eulerPi[i];
		}
		
		System.out.println(sum);
		
		sc.close();
		
	}
}