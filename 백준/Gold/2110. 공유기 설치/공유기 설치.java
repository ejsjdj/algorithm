import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
    static int N;
    static int C;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1] - arr[0];
        
        binarySearch(left, right);
        System.out.println(result);
    }
    
    static void binarySearch(int left, int right) {
    	
    	int mid;
    	
    	while (left <= right) {	
    		mid = (left + right) / 2;
    		int cnt = 1;
    		int idx = 0;
    		
    		for (int i = 1; i < N; i++) {
    			if (arr[i] - arr[idx] >= mid) {
    				cnt++;
    				idx = i;
    			}
    		}
    		if (cnt >= C) {
    			result = mid;
    			left = mid + 1;
    		} else {
    			right = mid - 1;
    		}
    	}
    }
}