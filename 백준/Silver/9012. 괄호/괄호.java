import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int cnt = sc.nextInt();
		 for (int i = 0; i < cnt; i++) {
			 if (val(sc.next()) == 0) System.out.println("NO");
			 else System.out.println("YES");
			 
		 }
		 sc.close();
	}
	
	static int val(String st) {
		if (st.charAt(0) != 40 || st.charAt(st.length() - 1) != 41)  return 0;
		
		int cnt = 0;
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) == 40) cnt++;
			else if (st.charAt(i) == 41) cnt--;
			
			if (cnt < 0) return 0;
		}
		
		if (cnt == 0) return 1;
		else return 0;
		
	}
}
