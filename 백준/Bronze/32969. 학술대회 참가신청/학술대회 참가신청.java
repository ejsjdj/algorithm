import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		if (str.contains("social")) System.out.println("digital humanities");
		else if (str.contains("history")) System.out.println("digital humanities");
		else if (str.contains("language")) System.out.println("digital humanities");
		else if (str.contains("literacy")) System.out.println("digital humanities");
		
		else if (str.contains("bigdata")) System.out.println("public bigdata");
		else if (str.contains("public")) System.out.println("public bigdata");
		else if (str.contains("society")) System.out.println("public bigdata");
		
		sc.close();
		
	}
}
