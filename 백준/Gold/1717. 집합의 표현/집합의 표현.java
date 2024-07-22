import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 원소의 개수는 n + 1 개
		int m = Integer.parseInt(st.nextToken()); // 연산의 개수
		
		arr = new int[n+1];	// 집합의 연결상태를 기록할 배열
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;	// 모든값이 자기 자신을 가르키도록 함.
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st.nextToken()); // d 가 0이면 합집합 1 은 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (d == 0) {	// d 가 0 즉 합집합일시
				union(a, b);	// b값의 연결상태를 a값의 연결상태가 가르키는 값으로 함.
			}
			else {
				if (checkSame(a, b)) System.out.println("YES"); // 두 값이 가르키는 값이 같으면 YES 아니면 Nㅒ를 출력
				else System.out.println("NO");
			}
		}
	}
	
	public static void union(int a, int b) { // 두 노드를 연결하기
		a = find(a);
		b = find(b);
		if (a != b) arr[b] = a;
	}
	
	public static int find(int a) {
		if (a == arr[a]) {			// 대표노드일 경우 해당값을 리턴
			return a;
		} else {
			return arr[a] = find(arr[a]);	// 대표노드를 찾을때 까지 재귀를 돌림.
		}
	}
	
	public static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return true;
		else return false;
	}
}