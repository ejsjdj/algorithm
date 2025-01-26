import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Animal {
    int code;
    int L;
    int R;

    Animal(int code, int L, int R) {
        this.code = code;
        if (L <= R) {
        	this.L = L;
        	this.R = R;        	
        } else {
        	this.R = L;
        	this.L = R;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Animal> list = new ArrayList<>();

        // 입력 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int code = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            list.add(new Animal(code, L, R));
        }

        // 활동 영역 정렬: L 오름차순, L 같으면 R 내림차순
        Collections.sort(list, (o1, o2) -> {
            if (o1.L == o2.L) return o2.R - o1.R; // R 내림차순
            return o1.L - o2.L;                   // L 오름차순
        });
        
        // 중복값 삭제
        for (int i = 0; i < list.size() - 1; i++) {
        	Animal A = list.get(i);
        	Animal B = list.get(i + 1);
        	if (A.L == B.L && A.R == B.R) {
        		list.remove(i);
        		i--;
        	}
        }
        
        List<Animal> lis = new ArrayList<>();
        
        for (Animal A : list) {
            int idx = Collections.binarySearch(lis, A, (o1, o2) -> {
            	return Integer.compare(o2.R, o1.R);
            });

            if (idx < 0) idx = -(idx + 1);

            // LIS 업데이트
            while (true) {
            	if (idx == lis.size()) {
            		lis.add(A);
            		break;
            	}
            	
            	else if (idx != lis.size() && lis.get(idx).R == A.R) idx++;
            	
            	else {
            		lis.set(idx, A);
            		break;
            	}
            }
        }

        // 최종 결과 출력
        System.out.println(lis.size());
    }
}