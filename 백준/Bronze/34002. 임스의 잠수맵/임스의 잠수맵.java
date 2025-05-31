import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int level = Integer.parseInt(st.nextToken());
		int exp = 0;
		int cnt = 0;
		
		while (level < 250) {
			if (V > 0) {
                int minute = 0;
                while (minute < 30) {
                    exp += C;
                    cnt++;
                    minute++;
                    if (exp >= 100) {
                        exp -= 100;
                        level++;
                    }
                    if (level == 250) break;
                }
				V--;
			} else if (S > 0) {
                int minute = 0;
                while (minute < 30) {
                    exp += B;
                    cnt++;
                    minute++;
                    if (exp >= 100) {
                        exp -= 100;
                        level++;
                    }
                    if (level == 250) break;
                }
				S--;
			} else {
				exp += A;
				cnt++;
        	    while (exp >= 100) {
                    exp -= 100;
                    level++;
                }        
			}
		}
		System.out.println(cnt);
	}
}