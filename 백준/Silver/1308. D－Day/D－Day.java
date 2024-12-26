import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int year1 = Integer.parseInt(st.nextToken());
		int month1 = Integer.parseInt(st.nextToken());
		int day1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int year2 = Integer.parseInt(st.nextToken());
		int month2 = Integer.parseInt(st.nextToken());
		int day2 = Integer.parseInt(st.nextToken());
		
		LocalDate date1 = LocalDate.of(year1, month1, day1);
		LocalDate date2 = LocalDate.of(year2, month2, day2);
		
        long yearsBetween = ChronoUnit.YEARS.between(date1, date2);

		if (yearsBetween >= 1000) {
			System.out.println("gg");
		}
		else {
			long daysBetween = ChronoUnit.DAYS.between(date1, date2);
			System.out.println("D-" + daysBetween);
		}
	}
}