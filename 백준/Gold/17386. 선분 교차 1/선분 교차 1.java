import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    long x, y;
    
    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class CCW {

    public int ccw(Point p1, Point p2, Point p3) {
        long cross = (p2.x - p1.x) * (p3.y - p1.y) 
                   - (p2.y - p1.y) * (p3.x - p1.x);
        
        if (cross > 0) return 1;
        if (cross < 0) return -1;
        return 0;
    }
    
    /**
     * 점 q가 선분 p-r 위에 있는지 판단합니다.
     */
    private boolean onSegment(Point p, Point q, Point r) {
        return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
               q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
    }
    
    /**
     * 두 선분이 교차하는지 판단합니다.
     */
    public boolean segmentIntersect(Point p1, Point p2, Point p3, Point p4) {
        int ccw1 = ccw(p1, p2, p3);
        int ccw2 = ccw(p1, p2, p4);
        int ccw3 = ccw(p3, p4, p1);
        int ccw4 = ccw(p3, p4, p2);
        
        // 일반적인 교차
        if (ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0) {
            return true;
        }
        
        // 모두 0인 경우: 두 선분이 같은 직선 위에 있음
        if (ccw1 == 0 && ccw2 == 0 && ccw3 == 0 && ccw4 == 0) {
            // 두 선분이 겹치는지 확인
            return onSegment(p1, p3, p2) || onSegment(p1, p4, p2) ||
                   onSegment(p3, p1, p4) || onSegment(p3, p2, p4);
        }
        
        // 끝점에서 만나는 경우
        if (ccw1 == 0 && onSegment(p1, p3, p2)) return true;
        if (ccw2 == 0 && onSegment(p1, p4, p2)) return true;
        if (ccw3 == 0 && onSegment(p3, p1, p4)) return true;
        if (ccw4 == 0 && onSegment(p3, p2, p4)) return true;
        
        return false;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        Point point1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point point2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point point3 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point point4 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        CCW ccw = new CCW();

        if (ccw.segmentIntersect(point1, point2, point3, point4)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}