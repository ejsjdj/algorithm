import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int time = sc.nextInt();
		sb.append(time/300 + " ");
		time = time % 300;
		sb.append(time/60 + " ");
		time = time % 60;
		sb.append(time/10);
		time = time % 10;
		if (time == 0) System.out.println(sb);
		else System.out.println(-1);

		sc.close();
	}
}