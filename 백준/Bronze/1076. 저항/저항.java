import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] color = new String[10];
		long[] value = new long[10];
		long[] multiple = new long[10];
		
		color[0] = "black";
		color[1] = "brown";
		color[2] = "red";
		color[3] = "orange";
		color[4] = "yellow";
		color[5] = "green";
		color[6] = "blue";
		color[7] = "violet";
		color[8] = "grey";
		color[9] = "white";
		
		for (int i = 0; i < 10; i++) {
			value[i] = i;
		}
		
		for (int i = 0; i < 10; i++) {
			multiple[i] = (int) Math.pow(10, i);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long first_value = value[Arrays.asList(color).indexOf(st.nextToken())];
		
		st = new StringTokenizer(br.readLine());
		long second_value = value[Arrays.asList(color).indexOf(st.nextToken())];
		
		st = new StringTokenizer(br.readLine());
		long multiple_value = multiple[Arrays.asList(color).indexOf(st.nextToken())];
		
		System.out.println((first_value * 10 + second_value) * multiple_value);
	}
}
