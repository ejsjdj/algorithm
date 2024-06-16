import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int degree = sc.nextInt();
		int start_point = sc.nextInt();
		
		int graph[][] = new int[size][size];
		int num[] = new int[size];
		int num1[] = new int[size];
		
		for (int i = 0; i < size; i++) {
			num[i] = 1;
		}
		for (int i = 0; i < size; i++) {
			num1[i] = 1;
		}
		
		for (int i = 0; i < degree; i++) {
			makeDegree(graph, sc.nextInt(), sc.nextInt());
		}
		
		DES(graph, num, start_point);
		System.out.println();
		
		Queue<Integer> queue = new LinkedList<>();
		
		BFS(graph,num1,start_point,queue);
		sc.close();
	}
	
	static void makeDegree(int arr[][], int x, int y) {
		arr[x-1][y-1] = 1;
		arr[y-1][x-1] = 1;
	}
	
	static void DES(int arr[][], int N[], int start_point) {
		System.out.print(start_point + " ");
		N[start_point - 1] = 0;
		for (int i = 1; i <= N.length; i ++) {
			if (arr[start_point-1][i-1] == 1 && N[i-1] == 1) DES(arr, N, i);
		}
	}
	
	static void BFS(int arr[][], int N[], int start_point, Queue queue) {
		if (N[start_point - 1] != 0) {
			System.out.print(start_point + " ");
			N[start_point - 1] = 0;
		}
		for (int i = 1; i <= N.length; i++) {
			if (arr[start_point - 1][i-1] == 1 && N[i-1] == 1) {
				System.out.print(i + " ");
				N[i - 1] = 0;
				queue.add(i);
			}
		}
		if (queue.size() != 0) BFS(arr,N,(int)queue.poll(),queue);
	}
}