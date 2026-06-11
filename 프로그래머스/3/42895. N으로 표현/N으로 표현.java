import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;

        List<Set<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {

            Set<Integer> set = list.get(i);
            int num = 0;
            for (int j = 1; j <= i; j++) {
                num *= 10;
                num += N;
            }
            set.add(num);

            for (int j = 1; j < i; j++) {
                Set<Integer> setA = list.get(j);
                Set<Integer> setB = list.get(i - j);

                for (int left : setA) {
                    for (int right : setB) {
                        set.add(left + right);
                        set.add(left - right);
                        set.add(left * right);
                        if (right != 0) set.add(left / right);
                    }
                }

            }

            if (set.contains(number)) return i;
        }

        return -1;
    }
}