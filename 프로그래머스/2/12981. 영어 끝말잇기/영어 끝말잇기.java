class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        boolean flag = true;
        int k = -1;
        
        while (flag) {
        	k++;
        	if (k == words.length) return new int[] {0,0};
        	for (int i = 0; i < k; i++) {
        		if (words[k].equals(words[i]) || words[k].charAt(0) != words[k-1].charAt(words[k-1].length() - 1)) { 
        			flag = false;
        			break;
        		}
        	}
        }
        answer[0] = k % n + 1;
        answer[1] = (k + n) / n;
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }
}