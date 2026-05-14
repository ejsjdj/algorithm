import java.util.*;

class Solution {
    
    List<Integer> keySet;
    int rowCount;
    int colCount;
    
    public int solution(String[][] relation) {
        int answer = 0;

        keySet = new ArrayList<>();
        rowCount = relation.length;
        colCount = relation[0].length;

        for (int mask = 1; mask < (1 << colCount); mask++) {

            if (isMinimal(mask) && isUnique(mask, relation)) {
                keySet.add(mask);
                answer++;
            }
        }

        return answer;
    }

    boolean isMinimal(int mask) {
        for (int key : keySet) {
            if ((key & mask) == key) return false;
        }
        return true;
    }

    boolean isUnique(int mask, String[][] relation) {


        Set<String> set = new HashSet<>();

        for (int i = 0; i < rowCount; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < colCount; j++) {
                if ((mask & (1 << j)) != 0) {
                    sb.append(relation[i][j]);
                }
            }

            if (!set.add(sb.toString())) return false;
        }
        return true;
    }
}