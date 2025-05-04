import java.util.LinkedList;

class Solution {
    public int[] solution(int n, int[] numlist) {
        LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < numlist.length; i++) {
			if (numlist[i] % n == 0) {
				linkedList.add(numlist[i]);
			}
		}
		int[] answer = new int[linkedList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = linkedList.get(i);
		}
        return answer;
    }
}