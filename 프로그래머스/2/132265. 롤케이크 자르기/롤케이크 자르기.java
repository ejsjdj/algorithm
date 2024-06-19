import java.util.HashSet;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 각 토핑의 개수를 세기 위한 배열
        int[] count = new int[10001]; // 토핑의 종류가 10000 이하라고 가정
        
        // 모든 토핑의 개수를 센다
        for (int t : topping) {
            count[t]++;
        }
        
        HashSet<Integer> leftSet = new HashSet<>();
        HashSet<Integer> rightSet = new HashSet<>();
        
        // 처음에는 모든 토핑이 오른쪽에 있다고 가정
        for (int t : topping) {
            rightSet.add(t);
        }
        
        // 토핑을 하나씩 왼쪽으로 이동하면서 비교
        for (int t : topping) {
            leftSet.add(t);
            count[t]--;
            
            if (count[t] == 0) {
                rightSet.remove(t);
            }
            
            // 왼쪽과 오른쪽의 토핑 종류가 같으면 결과 증가
            if (leftSet.size() == rightSet.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}