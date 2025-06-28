import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String data = sc.nextLine();
		boolean gg = false;
		
		if(N % 2 != 0) {
			N += 1;
		}
		int half = N / 2;
		int cnt = 0;
		
		for(int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			if(ch == 'O') {
				cnt++;
			} 
			if(cnt >= half) {
				gg = true;
				break;
			}
		}
		
		if(gg) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		sc.close();
		
	}
}