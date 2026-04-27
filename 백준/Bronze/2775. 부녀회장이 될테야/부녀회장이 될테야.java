import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] APT = new int[15][14];
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < 14; i++) {
			APT[0][i] = i+1;
		}
		
		for (int i = 1; i < 15; i++) {
			APT[i][0] = 1;
		}
		
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 14; j++) {
				APT[i][j] = APT[i-1][j] + APT[i][j-1];
			}
		}
		for (int i = 0; i < T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			System.out.println(APT[H][W-1]);
		}
	}
}
