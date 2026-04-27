import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException  {
		boolean arr[] = new boolean[30];
		for (int i = 0; i < 30; i++) {
			arr[i] = false;
		}
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 28; i++) {
			arr[Integer.parseInt(bf.readLine()) - 1] = true;
		}
		
		for (int i = 0; i < 30; i++) {
			if (arr[i] == false) System.out.println(i+1);
		}
	}

}
