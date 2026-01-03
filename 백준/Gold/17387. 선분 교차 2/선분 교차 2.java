import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point q = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		Point u = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point v = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		if (segmentIntersect(p,q,u,v)) System.out.println(1);
		else System.out.println(0);
	}
	
	static int CCW(Point p, Point q, Point r) {
		Point u = new Point(q.x - p.x, q.y - p.y);
		Point v = new Point(r.x - p.x, r.y - p.y);
		
		long cross = (long)u.x * v.y - (long)u.y * v.x;
		
		if (cross > 0) return 1;
		else if (cross < 0) return -1;
		else return 0;
	}
	
	static boolean segmentIntersect(Point p1, Point p2, Point p3, Point p4) {
		int ccw1 = CCW(p1, p2, p3);
		int ccw2 = CCW(p1, p2, p4);
		int ccw3 = CCW(p3, p4, p1);
		int ccw4 = CCW(p3, p4, p2);
		
		if (ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0) {
			return true;
		}
		
		if (ccw1 == 0 && onSegment(p1,p2,p3)) return true;
		else if (ccw2 == 0 && onSegment(p1,p2,p4)) return true;
		else if (ccw3 == 0 && onSegment(p3,p4,p1)) return true;
		else if (ccw4 == 0 && onSegment(p3,p4,p2)) return true;
		
		return false;
	}
	
	static boolean onSegment(Point p1, Point p2, Point p3) {
		return p3.x <= Math.max(p1.x, p2.x) && p3.x >= Math.min(p1.x, p2.x) && 
			   p3.y <= Math.max(p1.y, p2.y) && p3.y >= Math.min(p1.y, p2.y);
	}
}
