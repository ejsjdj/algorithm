import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int materialCnt = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int neededNum = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] materialArray = new int[materialCnt];
		
		for (int i = 0; i < materialCnt; i++) {
			materialArray[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(materialArray);
		
		int value = 0;
		int start_point = 0;
		int end_point = materialCnt - 1;
		
		
		while (start_point < end_point) {
			if (materialArray[start_point] + materialArray[end_point] == neededNum) {
				value += 1;
				start_point++;
				end_point--;
			} else if (materialArray[start_point] + materialArray[end_point] > neededNum) {
				end_point--;
			} else if (materialArray[start_point] + materialArray[end_point] < neededNum) {
				start_point++;
			}
		}
		System.out.println(value);
		br.close();
	}
}