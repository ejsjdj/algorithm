import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int k, d, a;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String kda = br.readLine();

		String[] arr = kda.split("/");
		
		k = Integer.parseInt(arr[0]);
		d = Integer.parseInt(arr[1]);
		a = Integer.parseInt(arr[2]);
		
		if (d == 0 || k+a < d ) {
			System.out.println("hasu");
		} else {
			System.out.println("gosu");
		}

	}

}