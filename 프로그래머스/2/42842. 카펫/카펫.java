import java.util.ArrayList;

class Solution {
    public int[] solution(int brown, int yellow) {

        
        // width;
        // height;
        // width * height = brown * yellow;
        // width + height = brown / 2 + 2;
        
        int total = brown + yellow;
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= total; i++) {
        	if (total % i == 0) {
        		arrayList.add(i);
        	}
        }

        int x = 0;
        int y = 0;
        for (int i = 0; i < arrayList.size(); i++) {
        	if ((arrayList.get(i) + arrayList.get(arrayList.size() - 1 - i)) == (brown / 2) + 2) {
        		y = arrayList.get(i);
        		x = arrayList.get(arrayList.size() - 1 - i);

        		break;
        		
        	}
        }
        int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}