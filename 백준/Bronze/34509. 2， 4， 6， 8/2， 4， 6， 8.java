public class Main {
	public static void main(String[] args) {
		
		for (int i = 10; i < 100; i++) {
			int a = i / 10;
			int b = i % 10;
			int k = b * 10 + a;
			if (k % 4 != 0) continue;
			if (a + b != 6) continue;
			if (a == 8 || b == 8) continue;
			System.out.println(i);
			break;
		}
		
	}
}