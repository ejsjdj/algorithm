import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long closestSum = Long.MAX_VALUE;
        long[] result = new long[3];

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;
            
            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                
                // 현재 합이 0에 더 가까운 경우 갱신
                if (Math.abs(sum) < Math.abs(closestSum)) {
                    closestSum = sum;
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }
                
                // 합이 0인 경우 즉시 종료
                if (sum == 0) {
                    System.out.println(result[0] + " " + result[1] + " " + result[2]);
                    return;
                } else if (sum < 0) {
                    left++; // 합을 증가시키기 위해 left 이동
                } else {
                    right--; // 합을 감소시키기 위해 right 이동
                }
            }
        }
        
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}