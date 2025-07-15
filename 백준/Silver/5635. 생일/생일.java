import java.util.Scanner;

class People {
	String name;
	int day;
	int month;
	int year;
	public People(String name, int day, int month, int year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		People older = null;
		People younger = null;
		
		for (int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split(" ");
			
			String name = str[0];
			int day = Integer.parseInt(str[1]);
			int month = Integer.parseInt(str[2]);
			int year = Integer.parseInt(str[3]);
			
			People now = new People(name, day, month, year);
			
			if (older == null) older = now;
			else {
				if (older.year > now.year) older = now;
				else if (older.year == now.year) {
					if (older.month > now.month) older = now;
					else if (older.month == now.month) {
						if (older.day > now.day) older = now;
					}
				}
			}
			
			if (younger == null) younger = now;
			else {
				if (younger.year < now.year) younger = now;
				else if (younger.year == now.year) {
					if (younger.month < now.month) younger = now;
					else if (younger.month == now.month) {
						if (younger.day < now.day) younger = now;
					}
				}
			}
		}
		System.out.println(younger.name);
		System.out.println(older.name);
		sc.close();
	}
}