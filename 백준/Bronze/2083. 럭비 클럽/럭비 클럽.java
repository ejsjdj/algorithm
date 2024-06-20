import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String[] word = sc.nextLine().split(" ");
			if (word[0].equals("#")) break;
			String name = word[0];
			int age = Integer.parseInt(word[1]);
			int weight = Integer.parseInt(word[2]);
			
			if (age > 17 || weight >= 80) System.out.println(name + " Senior");
			else System.out.println(name + " Junior");
			
		}
		sc.close();
	}
}