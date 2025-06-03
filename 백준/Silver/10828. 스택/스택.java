import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		for (int i = 0; i < cnt; i++) {
			String str = sc.next();
			if (str.contentEquals("push")) linkedList.add(sc.nextInt());
			else if (str.contentEquals("pop")) {
				if (linkedList.size() != 0) bw.write(linkedList.removeLast() + "\n");
				else bw.write(-1 + "\n");
			}
			else if (str.contentEquals("size")) bw.write(linkedList.size() + "\n");
			else if (str.contentEquals("empty")) {
				if (linkedList.size() == 0) bw.write(1 + "\n");
				else bw.write(0 + "\n");;
			}
			else if (str.contentEquals("top")) {
				if (linkedList.size() != 0) bw.write(linkedList.getLast() + "\n");
				else bw.write(-1 + "\n");
			}
		}
		bw.flush();
		bw.close();
		sc.close();
	}
}