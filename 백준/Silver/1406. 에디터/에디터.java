import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(br.readLine());
        int index = sb.length();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
        	String str = br.readLine();
        	if (str.charAt(0) == 'L') {
        		index--;
        		index = Math.max(index, 0);
        	} else if (str.charAt(0) == 'D') {
        		index++;
        		index = Math.min(index, sb.length());
        	} else if (str.charAt(0) == 'B') {
        		if (index == 0) continue;
        		sb.deleteCharAt(--index);
        		
        	} else if (str.charAt(0) == 'P') {
        		sb.insert(index++, str.charAt(2));
        	}
        }
        System.out.println(sb);
    }
}