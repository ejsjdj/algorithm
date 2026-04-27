import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String arr[][] = new String[20][3];
		
		for (int i =0; i < 20; i ++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
			arr[i][2] = st.nextToken();
		}
		
		double p_cnt = 0;
		double sum = 0;
		for (int i = 0; i < 20; i++) {
			if (arr[i][2].contentEquals("P")) {
			} else {
				sum += calification(arr[i][2]) * Double.parseDouble(arr[i][1]);
				p_cnt += Double.parseDouble(arr[i][1]);
			}
		}
		
		System.out.println(sum / p_cnt);
		
	}
	
	static double calification(String cal) {
		switch (cal) {
		case "A+": return 4.5;
		case "A0": return 4.0;
		case "B+": return 3.5;
		case "B0": return 3.0;
		case "C+": return 2.5;
		case "C0": return 2.0;
		case "D+": return 1.5;
		case "D0": return 1.0;
		}
		return 0.0;
	}
}