import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			hm.put(str.charAt(0), hm.getOrDefault(str.charAt(0), 0)+1);
		}
		
		List<Character> list = new LinkedList<>();
		Set<Character> set = new HashSet<>();
		set = hm.keySet();
		for (Character ch : set) {
			if (hm.get(ch) >= 5) list.add(ch);
		}
		Collections.sort(list);
		if (list.isEmpty()) System.out.println("PREDAJA");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
}


