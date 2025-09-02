import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// N개의 팀
		int M = Integer.parseInt(st.nextToken());	// M개의 의자를 가지고있다.
		int A = Integer.parseInt(st.nextToken());	// 개당 가격
		int B = Integer.parseInt(st.nextToken());	// 운송료
		
		if (N * 3 <= M) System.out.println(0);
		else System.out.println((N * 3 - M) * A + B);
		
	}
}
