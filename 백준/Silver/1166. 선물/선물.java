import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextInt();	// 선물할 박스의 수
		long L = sc.nextInt();	// 박스의 가로
		long W = sc.nextInt();	// 세로
		long H = sc.nextInt();	// 높이
		
		double high = Math.min(Math.min(L, W), H); // 가장 작은 길이
		double low = 0;
		double mid = 0;
		
		while (high > low) {
			mid = (high + low) / 2;
			
			if ((long)(L / mid) * (long)(W / mid) * (long)(H / mid) < N) {
				if (high == mid) break;
				high = mid;
			}
			else {
				if (low == mid) break;
				low = mid;
			}
		}
		
		System.out.println(mid);
		sc.close();
	}
}