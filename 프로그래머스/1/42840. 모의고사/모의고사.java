class Solution {
    public int[] solution(int[] answers) {
        
//        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
        
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
        	int N = answers[i];
        	if (N == first[i%first.length]) cnt1++;
        	if (N == second[i%second.length]) cnt2++;
        	if (N == third[i%third.length]) cnt3++;
        }
        
        if (cnt1 == cnt2 && cnt2 == cnt3) return new int[] {1, 2, 3};
        else if (cnt1 == cnt2 && cnt2 > cnt3) return new int[] {1, 2};
        else if (cnt2 == cnt3 && cnt3 > cnt1) return new int[] {2, 3};
        else if (cnt1 == cnt3 && cnt1 > cnt2) return new int[] {1, 3};
        else if (cnt1 > cnt2 && cnt1 > cnt3) return new int[] {1};
        else if (cnt2 > cnt3 && cnt2 > cnt1) return new int[] {2};
        else return new int[] {3};
    }
}