import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		for(int i = 0; i < cnt; i++) {
			String str = sc.next();
			String substr1=str.substring(0,1);
			String substr2=str.substring(str.length()-1);
			System.out.print(substr1);
			System.out.println(substr2);
		}
		sc.close();
	}

}
