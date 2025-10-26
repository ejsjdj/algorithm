import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class Plan implements Comparable<Plan>{
	
	String name;
	int startHour;
	int startMinutes;
	int playTime;
	
	public Plan(String name, String start, String playTime) {
		
		this.name = name;
		
		String[] str = start.split(":");
		
		this.startHour = Integer.parseInt(str[0]);
		this.startMinutes = Integer.parseInt(str[1]);
		
		this.playTime = Integer.parseInt(playTime);
	}
	
	@Override
	public int compareTo(Plan other) {
		if (this.startHour != other.startHour) return this.startHour - other.startHour;
		return this.startMinutes - other.startMinutes;
	}
}


class Solution {
	
	int nextHour;
	int nextMinute;
	
	int nowHour;
	int nowMinute;
	
    public String[] solution(String[][] plans) {
        List<String> names = new ArrayList<>();
        
		PriorityQueue<Plan> pq = new PriorityQueue<>();
		Stack<Plan> stack = new Stack<>();
        
		for (int i = 0; i < plans.length; i++) {
			String name = plans[i][0];
			String start = plans[i][1];
			String playTime = plans[i][2];
			
			pq.add(new Plan(name, start, playTime));
		}
		
		// 처음거로 시작
		Plan now = pq.poll();
		
		while (!pq.isEmpty()) {			
			
			// 다음것과 지금꺼의 시간간격을 계산
			nextHour = pq.peek().startHour;
			nextMinute = pq.peek().startMinutes;
			
			nowHour = now.startHour;
			nowMinute = now.startMinutes;
			
			int hourDiff = nextHour - nowHour;
			int minuteDiff = nextMinute - nowMinute;
			// 시간 간격
			int time = hourDiff * 60 + minuteDiff;
			
			// 만약 지금 하고있는일의 필요시간이 간격시간보다 짧다면 끝냄
			if (now.playTime <= time) {
				time -= now.playTime;
				names.add(now.name);
				
			// 만약 지금 하고 있는 작업의 시간이 더 길다면 간격시간만큼만 시간을 빼주고 deque에 넣음
			} else {
				now.playTime -= time;
				time = 0;
				stack.push(now);
			}
			
			// 만약 시간이 남으면 밀린 일들을 함
			while (time > 0 && !stack.isEmpty()) {
				// 가장 많이 밀린일
				Plan rest = stack.pop();
				
				
				if (rest.playTime <= time) {
					time -= rest.playTime;
					names.add(rest.name);
				} else {
					rest.playTime -= time;
					time = 0;
					stack.push(rest);
				}
			}
			
			now = pq.poll();
		}
		
		if (now.playTime > 0) names.add(now.name);
		
		while (!stack.isEmpty()) {
			names.add(stack.pop().name);
		}
		
        return names.stream().toArray(String[] :: new);
    }
}