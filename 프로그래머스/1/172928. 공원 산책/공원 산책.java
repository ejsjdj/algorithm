class Solution {    
    int x_size;
    int y_size;
    
    // 이동범위 체크
    boolean width_check(int now, int move, int size) {
        return 0 <= now + move && now + move < size;
    }
    
    // 장애물 체크
    boolean obstacle_check(String[] park, int[] now, int move, char direction) {
        int start, end;
        if (direction == 'E' || direction == 'W') {
            start = Math.min(now[1], now[1] + move);
            end = Math.max(now[1], now[1] + move);
            for (int i = start; i <= end; i++) {
                if (park[now[0]].charAt(i) == 'X') return false;
            }
        } else {
            start = Math.min(now[0], now[0] + move);
            end = Math.max(now[0], now[0] + move);
            for (int i = start; i <= end; i++) {
                if (park[i].charAt(now[1]) == 'X') return false;
            }
        }
        return true;
    }
    
    int[] start(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') return new int[] {i, j};
            }
        }
        return new int[] {0, 0}; // 시작점을 찾지 못한 경우 기본값 반환
    }
    
    public int[] solution(String[] park, String[] routes) {
        x_size = park[0].length();
        y_size = park.length;
        
        int[] current = start(park);
        
        for (String route : routes) {
            char direction = route.charAt(0);
            int move = Integer.parseInt(route.split(" ")[1]);
            
            int[] next = new int[] {current[0], current[1]};
            switch (direction) {
                case 'E': next[1] += move; break;
                case 'W': next[1] -= move; break;
                case 'S': next[0] += move; break;
                case 'N': next[0] -= move; break;
            }
            
            if (width_check(current[0], next[0] - current[0], y_size) &&
                width_check(current[1], next[1] - current[1], x_size) &&
                obstacle_check(park, current, next[direction == 'E' || direction == 'W' ? 1 : 0] - current[direction == 'E' || direction == 'W' ? 1 : 0], direction)) {
                current = next;
            }
        }
        
        return current;
    }
}