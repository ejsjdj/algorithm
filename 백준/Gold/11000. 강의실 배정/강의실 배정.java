import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Curso {
	
	int start;
	int end;
	
	public Curso(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Curso> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.start != o2.start) return o1.start - o2.start;
			else return o1.end - o2.end;
		});
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new Curso(start, end));
		}
		
		PriorityQueue<Integer> endTime = new PriorityQueue<>();
		endTime.add(0);
		while (!pq.isEmpty()) {
			Curso curso = pq.poll();
			if (endTime.peek() <= curso.start) {
				endTime.poll();
				endTime.add(curso.end);
			} else {
				endTime.add(curso.end);
			}
		}
		System.out.println(endTime.size());
	}
}