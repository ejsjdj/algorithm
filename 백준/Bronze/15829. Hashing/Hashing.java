import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("a", 1);
		hm.put("b", 2);
		hm.put("c", 3);
		hm.put("d", 4);
		hm.put("e", 5);
		hm.put("f", 6);
		hm.put("g", 7);
		hm.put("h", 8);
		hm.put("i", 9);
		hm.put("j", 10);
		hm.put("k", 11);
		hm.put("l", 12);
		hm.put("m", 13);
		hm.put("n", 14);
		hm.put("o", 15);
		hm.put("p", 16);
		hm.put("q", 17);
		hm.put("r", 18);
		hm.put("s", 19);
		hm.put("t", 20);
		hm.put("u", 21);
		hm.put("v", 22);
		hm.put("w", 23);
		hm.put("x", 24);
		hm.put("y", 25);
		hm.put("z", 26);
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += hm.get(String.valueOf(str.charAt(i))) * Math.pow(31, i);
		}
		System.out.println(sum);
	}
}