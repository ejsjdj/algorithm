import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int[] parent;
	public static int[] trueP;
	public static ArrayList<Integer>[] party;
	public static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람의 수
		int M = sc.nextInt(); // 파티의 수
		int T = sc.nextInt(); // 진실을 아는 사람의 수
		
		result = 0;
		
		trueP = new int[T];
		for (int i = 0; i < T; i++) {	// 진실을 아는 사람들을 trueP 배열에 넣음
			trueP[i] = sc.nextInt();
		}
		
		party = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<Integer>();
			int party_size = sc.nextInt();
			for (int j = 0; j < party_size; j++) {
				party[i].add(sc.nextInt());
			}
		}
		
		parent = new int[N + 1];
		for (int i = 0; i < parent.length; i++) {	// 각 노드가 자기 자신을 가르키도록 설정
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			int firstPeople = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		for (int i = 0; i < M; i++) {
			int firstPeople = find(party[i].get(0));
			boolean flag = true;
			for (int j = 0; j < trueP.length; j++) {
				if (checkSame(firstPeople,find(trueP[j]))) {
					flag = false;
					break;
				}
			}
			if (flag) result++;
		}
		System.out.println(result);
		
	}
	
	public static int find(int a) {
		if (a == parent[a]) return a;
		else {
			return parent[a] = find(parent[a]);
		}
	}
	
	public static void union (int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) parent[b] = a;
	}
	
	public static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return true;
		else return false;
	}
}