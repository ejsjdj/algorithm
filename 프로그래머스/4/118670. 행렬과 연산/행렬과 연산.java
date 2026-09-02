import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int R = rc.length;
        int C = rc[0].length;
        
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        Deque<Deque<Integer>> rows = new ArrayDeque<>();
        
        for (int r = 0; r < R; r++) {
            left.addLast(rc[r][0]);
            Deque<Integer> row = new ArrayDeque<>();
            for (int c = 1; c < C - 1; c++) {
                row.addLast(rc[r][c]);
            }
            rows.addLast(row);
            right.addLast(rc[r][C - 1]);
        }
        
        for (String s : operations) {
            if (s.equals("Rotate")) {
                int v = left.pollFirst();
                if (C > 2) {
                    rows.peekFirst().addFirst(v);
                    v = rows.peekFirst().pollLast();
                }
                right.addFirst(v);
                v = right.pollLast();
                if (C > 2) {
                    rows.peekLast().addLast(v);
                    v = rows.peekLast().pollFirst();
                }
                left.addLast(v);
            } else {
                left.addFirst(left.pollLast());
                right.addFirst(right.pollLast());
                rows.addFirst(rows.pollLast());
            }
        }
        
        int[][] answer = new int[R][C];
        
        for (int r = 0; r < R; r++) {
            answer[r][0] = left.pollFirst();
            if (C > 2) {
                Deque<Integer> row = rows.pollFirst();
                for (int c = 1; c < C - 1; c++) {
                    answer[r][c] = row.pollFirst();
                }
            }
            answer[r][C - 1] = right.pollFirst();
        }
        
        return answer;
    }
}