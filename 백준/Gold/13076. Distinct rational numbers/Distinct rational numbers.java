import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		int[] eulerPi = new int[10001];
		for (int i = 0; i < eulerPi.length; i++) {
			eulerPi[i] = i;
		}
		
		for (int i = 2; i < eulerPi.length; i++) {
			if (eulerPi[i] == i) {
				for (int j = i; j < eulerPi.length; j += i) {
					eulerPi[j] -= eulerPi[j] / i;
				}
			}
			eulerPi[i] += eulerPi[i - 1];
		}
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int input  = Integer.parseInt(st.nextToken());
			sb.append(eulerPi[input] + 1).append("\n");
		}
		
		System.out.println(sb);
	}
}