import java.util.*;

class Job implements Comparable<Job>{
    int requestTime, workingTime, id;
    static int seq = 1;
    public Job(int requestTime, int workingTime) {
        this.requestTime = requestTime;
        this.workingTime = workingTime;
        this.id = seq++;
    }
    
	public int compareTo(Job o) {
		if (this.workingTime != o.workingTime)
			return this.workingTime - o.workingTime;
		if (this.requestTime != o.requestTime)
			return this.requestTime - o.requestTime;
		return this.id - o.id;
	}
}

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간 기준 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        Queue<Job> pq = new LinkedList<>();
        for (int[] job: jobs) pq.add(new Job(job[0], job[1]));

        PriorityQueue<Job> disk = new PriorityQueue<>();

        int time = 0;
        int ans = 0;
        int n = jobs.length;
        
        while (!pq.isEmpty() || !disk.isEmpty()) {
            while (!pq.isEmpty() && pq.peek().requestTime <= time) disk.offer(pq.poll());
            
            if (!disk.isEmpty()) {
                Job job = disk.poll();
                if (time < job.requestTime) time = job.requestTime;
                time += job.workingTime;
                ans += time - job.requestTime;
            } else if (!pq.isEmpty()) {
                time = pq.peek().requestTime;
            }
        }
        return ans / n;
    }
}