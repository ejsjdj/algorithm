import java.util.Arrays;
import java.util.Scanner;

class A {
	int age;
	int idx;
	String name;
	public A(int age, int idx, String name) {
		this.age = age;
		this.name = name;
		this.idx = idx;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		A[] arr = new A[N];
		
		for (int i = 0; i < N; i++) {
			String[] input = sc.nextLine().split(" ");
			arr[i] = new A(Integer.parseInt(input[0]), i, input[1]);
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if (o1.age - o2.age > 0) return 1;
			else if (o1.age == o2.age) {
				return o1.idx - o2.idx;
			}
			else return -1;
		});
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i].age + " " + arr[i].name);
			System.out.println();
		}
	}
}