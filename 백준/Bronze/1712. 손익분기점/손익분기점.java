import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int fixedCost = sc.nextInt();
		int variableCost = sc.nextInt();
		int priceOfNotebook = sc.nextInt();
		
		int cnt = 0;
		
		if (variableCost < priceOfNotebook) {
			while (true) {
				if (fixedCost < (priceOfNotebook - variableCost) * cnt) {
					System.out.println(cnt);
					break;
				}
				else {
					cnt += 1;
				}
			}
		} else {
			System.out.println(-1);
		}
	}
}