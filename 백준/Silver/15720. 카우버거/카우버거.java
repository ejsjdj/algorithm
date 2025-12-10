import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); 
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken()); 

        int min = Math.min(B, Math.min(C, D));

        int[] burgers = new int[B];
        int[] sides = new int[C];
        int[] beverages = new int[D];

        int before = 0;
        st = new StringTokenizer(br.readLine());
        for(int b = 0; b < B; b++) {
            int price = Integer.parseInt(st.nextToken());
            burgers[b] = price;
            before += price;
        }
        st = new StringTokenizer(br.readLine());
        for(int c = 0; c < C; c++) {
            int price = Integer.parseInt(st.nextToken());
            sides[c] = price;
            before += price;
        }
        st = new StringTokenizer(br.readLine());
        for(int d = 0; d < D; d++) {
            int price = Integer.parseInt(st.nextToken());
            beverages[d] = price;
            before += price;
        }
        reverseSort(burgers);
        reverseSort(sides);
        reverseSort(beverages);

        int after = before;
        for(int i = 0; i < min; i++) {
            int sum = burgers[i] + sides[i] + beverages[i];
            after -= (sum / 10);
        }

        System.out.println(before);
        System.out.println(after);
        br.close();
    }

    public static void reverseSort(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
}