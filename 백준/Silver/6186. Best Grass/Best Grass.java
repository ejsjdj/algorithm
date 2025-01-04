import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int answer = 0;
		visited = new boolean[row][col];
		
		String[] grass = new String[row];
		
		for (int i = 0; i < row; i++) {
			grass[i] = bf.readLine();
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				
				if (grass[i].charAt(j) == '#' && !visited[i][j]) {
					answer++;
					
					if (i < row-1 && grass[i + 1].charAt(j) == '#') visited[i+1][j] = true;
					if (j < col - 1 && grass[i].charAt(j + 1) == '#') visited[i][j+1] = true;
					
				}
				
				visited[i][j] = true;
			}
		}
		
		System.out.println(answer);
		
	}
}