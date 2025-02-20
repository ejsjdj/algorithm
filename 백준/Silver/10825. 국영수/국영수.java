import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	
	String name;
	int kor;
	int eng;
	int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public int compareTo(Student o) {
		if (this.kor != o.kor) {
			return o.kor - this.kor;
		} else if (this.eng != o.eng) {
			return this.eng - o.eng;
		} else if (this.math != o.math){
			return o.math - this.math;
		} else {
			return this.name.compareTo(o.name);
		}
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Student[] arr = new Student[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			arr[i] = new Student(name, kor, eng, math);
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].name);
		}
	}
}