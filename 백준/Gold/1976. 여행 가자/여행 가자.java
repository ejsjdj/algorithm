import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static int[] cities;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt(); // 도시의 수
		int M = sc.nextInt(); // 여행할 도시의 개수
		
		cities = new int[N+1];	// 도시가 같은 그룹에 포함이 되어 있는지를 기록할 배열
		
		for (int i = 0; i < cities.length; i++) {
			cities[i] = i;	// 배열의 각 인덱스는 자기 자신을 가르키도록 초기화
		}
		
		for (int i = 1; i < cities.length; i++) {
			for (int j = 1; j < cities.length; j++) {
				int d = sc.nextInt();
				if (d == 1) {
					union(i, j);
				}
			}
		}
		
		int stan = find(sc.nextInt());
		boolean flag = true;
		for (int i = 1; i < M; i++) {
			if (!search(stan, sc.nextInt())) {
				flag = false;
				break;
			}
		}
		
		if (flag) System.out.println("YES");
		else System.out.println("NO");
		
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) cities[b] = a;
	}
	
	static int find(int num) {
		if (num == cities[num]) return num;
		else {
			return cities[num] = find(cities[num]);
		}
	}
	
	static boolean search(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return true;
		else return false; 
	}
	
}