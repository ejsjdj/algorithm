import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class Main {
//	public static void main(String[] args) throws IOException {
//		
//		StringBuilder sb = new StringBuilder();
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		
//		int[] arr1 = new int[N];
//		int[] arr2 = new int[M];
//		int[] answer = new int[N+M];
//		
//		st = new StringTokenizer(bf.readLine());
//		for (int i = 0; i < N; i++) {
//			arr1[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		st = new StringTokenizer(bf.readLine());
//		for (int i = 0; i < M; i++) {
//			arr2[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		int first = 0;
//		int second = 0;
//		for (int i = 0; i < answer.length; i++) {
//			if (first < N && second < M) {
//				if (arr1[first] < arr2[second]) {
//					answer[i] = arr1[first++];  
//				} else {
//					answer[i] = arr2[second++];
//				} 
//			} else if (first == N) answer[i] = arr2[second++];
//			else answer[i] = arr1[first++];
//		}
//		
//		for (int i = 0; i < N + M; i++) {
//			sb.append(answer[i] + " ");
//		}
//		
//		System.out.println(sb);
//	}
//}
public class Main {
   public static void main(String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuilder sb = new StringBuilder();
      
      int[] A = new int[Integer.parseInt(st.nextToken())];
      int[] B = new int[Integer.parseInt(st.nextToken())];
      
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < A.length; i++) {
         A[i] = Integer.parseInt(st.nextToken());
      }
      
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < B.length; i++) {
         B[i] = Integer.parseInt(st.nextToken());
      }
      
      int AIdx = 0;
      int BIdx = 0;
      
      while (AIdx < A.length || BIdx < B.length) {
         
         if(AIdx < A.length && BIdx < B.length) {
            if(A[AIdx] < B[BIdx]) {
               sb.append(A[AIdx++]);
            } else {
               sb.append(B[BIdx++]);
            }
         } else if (AIdx < A.length) {
            sb.append(A[AIdx++]);
         } else if (BIdx < B.length) {
            sb.append(B[BIdx++]);
         }
         sb.append(" ");
         
      }
      
      System.out.println(sb.toString().trim());
      
      br.close();
   }
}