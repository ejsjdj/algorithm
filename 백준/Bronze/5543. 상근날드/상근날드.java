import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] hamburgerArray = new int[3];
		int[] drinkArray = new int[2];
		
		for (int i = 0; i < 3; i++) {
			hamburgerArray[i] = sc.nextInt();
		}
		
		Arrays.sort(hamburgerArray);
		
		for (int i = 0; i < 2; i++) {
			drinkArray[i] = sc.nextInt();
		}
		
		Arrays.sort(drinkArray);
		
		sc.close();
		
		System.out.println(hamburgerArray[0] + drinkArray[0] - 50);
	}

}
