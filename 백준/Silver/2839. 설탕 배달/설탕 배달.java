import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int kg = sc.nextInt();
		sc.close();
		
		int cnt = 0;
		
		while (kg >= 3) {
			if (kg % 5 == 0) {
				cnt += kg / 5;
				kg = kg % 5;
			}
			else if (kg % 3 == 0 && kg < 15) {
				cnt += kg / 3;
				kg = kg % 3;
			} else {
				kg -= 5;
				cnt ++;
			}
		}
		if (kg == 0) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}
}
