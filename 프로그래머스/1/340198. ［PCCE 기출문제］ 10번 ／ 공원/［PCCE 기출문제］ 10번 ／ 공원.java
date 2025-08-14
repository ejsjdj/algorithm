import java.util.Arrays;

class Solution {

    int[] mats;
    String[][] park;

    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        this.mats = mats;
        this.park = park;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                if (park[i][j].equals("-1")) { // 시작점이 "-1"일 때만 검사
                    answer = Math.max(answer, BES(i, j, 0));
                }
            }
        }

        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            if (answer >= mats[i]) return mats[i];
        }

        return -1;
    }

    public int BES(int x, int y, int size) {
        // 다음 사이즈가 범위를 벗어나면 종료
        if (x + size >= park.length || y + size >= park[0].length) {
            return size;
        }

        // 정사각형 전체 검사
        for (int i = x; i <= x + size; i++) {
            for (int j = y; j <= y + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return size; // 현재 size 불가능
                }
            }
        }

        // 다음 크기 시도
        return BES(x, y, size + 1);
    }
}