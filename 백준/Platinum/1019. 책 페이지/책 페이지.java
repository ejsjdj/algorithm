import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10]; 

        int factor = 1; 
        
        while (N / factor > 0) { 
            int lower = N - (N / factor) * factor; 
            int current = (N / factor) % 10;      
            int higher = N / (factor * 10);       

            // 높은 자리수로 인해 발생하는 반복
            for (int i = 0; i < 10; i++) {
                arr[i] += higher * factor;
            }

            // 현재 자리에 따라 추가적으로 발생하는 경우
            for (int i = 0; i < current; i++) {
                arr[i] += factor;
            }
            arr[current] += lower + 1;

            // 가장 높은 자리에 '0'이 등장하지 않음
            arr[0] -= factor;

            factor *= 10; // 다음 자리로 이동
        }

        // 결과 출력
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}