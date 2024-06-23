import java.util.Scanner;

public class Main {
	static int part(int N) {
		int[] arr = {1, 2, 4};
		if (N == 1) return arr[0];
		if (N == 2) return arr[1];
		if (N == 3) return arr[2];
		return part(N-1) + part(N-2) + part(N - 3);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.println(part(sc.nextInt()));
		}
		
//		1을 나타내는 방법은 1개 1
//		2를 나타내는 방법은 2개 11, 2 
//		3을 나타내는 방법은 4개 111 21 12 3 
//		4를 나타내는 방법 1111, 211, 121, 112, 22, 31, 13 7개
//		5를 나타내는 방밥 11111, 2111, 1211, 1121, 1112, 221, 212, 122, 311, 131, 113, 32, 23 13개
//		6을 나타내는 방법 
//		7은 2개의 3과 하나의 1 3*3*3
		sc.close();
	}
}