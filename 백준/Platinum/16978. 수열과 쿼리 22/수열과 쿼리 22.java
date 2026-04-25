import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Query implements Comparable<Query> {
    int k;    
    int type;   
    int a, b;  
    int idx;   

    @Override
    public int compareTo(Query o) {
        return Integer.compare(this.k, o.k);
    }

    public Query(int k, int type, int a, int b, int idx) {
        this.k = k;
        this.type = type;
        this.a = a;
        this.b = b;
        this.idx = idx;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;

    static long[] tree;
    static long[] cur;     
    static Query[] q2;  
    static int q2Cnt = 0;
    static long[] answer;

    static class Update {
        int idx;
        long val;
        Update(int idx, long val) {
            this.idx = idx;
            this.val = val;
        }
    }
    static Update[] upd;
    static int updCnt = 0;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        tree = new long[N + 2];
        cur  = new long[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            long val = Long.parseLong(st.nextToken());
            cur[i] = val;
            update(i, val);
        }

        M = Integer.parseInt(br.readLine());

        upd = new Update[M + 1];      
        q2  = new Query[M + 1];      
        answer = new long[M + 1];   

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int idx = Integer.parseInt(st.nextToken());
                long val = Long.parseLong(st.nextToken());
                upd[++updCnt] = new Update(idx, val);
            } else { 
                int k = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                q2[q2Cnt] = new Query(k, 2, l, r, q2Cnt);
                q2Cnt++;
            }
        }

        q2 = Arrays.copyOf(q2, q2Cnt);
        Arrays.sort(q2);

        int applied = 0;

        for (int i = 0; i < q2Cnt; i++) {
            Query q = q2[i];
            
            while (applied < q.k) {
                applied++;
                Update u = upd[applied];
                int pos = u.idx;
                long newVal = u.val;
                long diff = newVal - cur[pos];
                cur[pos] = newVal;
                update(pos, diff);
            }
            int l = q.a;
            int r = q.b;
            answer[q.idx] = query(l, r);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q2Cnt; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb);
    }


    static void update(int i, long v) {
        while (i <= N) {
            tree[i] += v;
            i += (i & -i);
        }
    }

    static long get(int i) {
        long res = 0;
        while (i > 0) {
            res += tree[i];
            i -= (i & -i);
        }
        return res;
    }

    static long query(int l, int r) {
        return get(r) - get(l - 1);
    }
}