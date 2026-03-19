import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long price = Long.parseLong(st.nextToken());
        long bigBill = Long.parseLong(st.nextToken());
        long smallBill = Long.parseLong(st.nextToken());

        if (bigBill < smallBill) {
            long temp = bigBill;
            bigBill = smallBill;
            smallBill = temp;
        }

        long answer = Long.MAX_VALUE;

        long maxBillCount = smallBill - 1;
        if (maxBillCount > price / bigBill + 2) {
            maxBillCount = price / bigBill + 2;
        }

        for (long i = 0; i <= maxBillCount; i++) {
            long base = bigBill * i;

            if (base >= price) {
                answer = Math.min(answer, base);
                continue;
            }

            long rest = price - base;
            long smallCount = (rest + smallBill - 1) / smallBill;
            long total = base + smallCount * smallBill;

            answer = Math.min(answer, total);
        }

        System.out.println(answer);
    }
}
