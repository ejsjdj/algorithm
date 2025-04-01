import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		
		LocalDateTime time = LocalDateTime.now();
		
        int year = time.getYear();
        int month = time.getMonthValue();
        int day = time.getDayOfMonth();
        
        System.out.println(year);
        System.out.println(month < 10 ? "0" + month : month);
        System.out.println(day < 10 ? "0" + day : day);
		
	}
}