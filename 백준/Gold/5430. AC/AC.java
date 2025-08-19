import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {

        String[] numbersArr;
        Deque<Integer> deque = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String order = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String numbers = br.readLine();
            if (numbers.length() != 2) {
                numbersArr = numbers.substring(1, numbers.length() - 1).split(",");
                for (int i = 0; i < numbersArr.length; i++) {
                    deque.add(Integer.parseInt(numbersArr[i]));
                }
            }

            boolean flag = true;
            boolean errorFlag = false;
            for (int i = 0; i < order.length(); i++) {
                char ch = order.charAt(i);
                if (ch == 'R') flag = !flag;
                else if (ch == 'D') {
                    if (deque.isEmpty()) {
                        errorFlag = true;
                        System.out.println("error");
                        break;
                    } else {
                        if (flag) {
                            deque.pollFirst();
                        } else if (!flag) {
                            deque.pollLast();
                        }
                    }
                }
            }
            if (!errorFlag) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (flag) {
                    int dequeSize = deque.size();
                    for (int i = 0; i < dequeSize; i++) {
                        sb.append(deque.pollFirst());
                        if (i != dequeSize - 1) {
                            sb.append(",");
                        }
                    }
                }
                else {
                    int dequeSize = deque.size();
                    for (int i = 0; i < dequeSize; i++) {
                        sb.append(deque.pollLast());
                        if (i != dequeSize - 1) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }

        }

    }

}