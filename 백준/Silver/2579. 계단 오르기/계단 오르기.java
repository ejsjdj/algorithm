import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int[] arr;
	static Integer[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        arr = new int[N + 1];
        result = new Integer[N + 1];
        
        for (int i = 1; i < arr.length; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        result[0] = 0;
        result[1] = arr[1];
        
        if (N >= 2) result[2] = arr[1] + arr[2];
        
        System.out.println(move(N));
        br.close();
    }
    
    static int move(int step) {
    	
    	if (result[step] == null) {
    		result[step] = Math.max(move(step - 2) + arr[step], move(step - 3) + arr[step - 1] + arr[step]);
    	}
    	
    	return result[step];
    }
    
}