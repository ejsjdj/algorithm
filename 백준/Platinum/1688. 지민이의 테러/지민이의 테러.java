import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        double[] polygonX = new double[N];
        double[] polygonY = new double[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            polygonX[i] = Double.parseDouble(st.nextToken());
            polygonY[i] = Double.parseDouble(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        // 문제에서 3명의 위치가 주어진다고 했으므로 loop 3번 (BOJ 1688 기준)
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            double pointX = Double.parseDouble(st.nextToken());
            double pointY = Double.parseDouble(st.nextToken());

            // 1. 점이 내부에 있거나 경계선에 있으면 1
            if (isPointInPolygon(pointX, pointY, polygonX, polygonY)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isPointInPolygon(double pointX, double pointY, double[] polygonX, double[] polygonY) {
        int n = polygonX.length;
        boolean inside = false;

        for (int i = 0, j = n - 1; i < n; j = i++) {
            double xi = polygonX[i], yi = polygonY[i];
            double xj = polygonX[j], yj = polygonY[j];

            // 점이 선분(경계선) 위에 있는지 우선 확인
            if (onSegment(pointX, pointY, xi, yi, xj, yj)) {
                return true; // 경계선 위라면 무조건 내부(1)로 처리
            }

            // Ray Casting
            // (yi > pointY) != (yj > pointY) : 점의 Y좌표가 선분의 Y 범위 사이에 있는가?
            boolean intersectY = (yi > pointY) != (yj > pointY);
            
            if (intersectY) {
                // 교차점의 X 좌표 계산
                double intersectX = (xj - xi) * (pointY - yi) / (yj - yi) + xi;
                
                // 점이 교차점의 왼쪽(또는 오른쪽)에 있는가?
                if (pointX < intersectX) {
                    inside = !inside;
                }
            }
        }
        return inside;
    }

    // 점(px, py)이 선분 (x1,y1)-(x2,y2) 위에 있는지 검사하는 함수
    private static boolean onSegment(double px, double py, double x1, double y1, double x2, double y2) {
        // 1. 기울기 확인 (CCW 혹은 기울기가 같은지)
        // (x - x1) / (x2 - x1) == (y - y1) / (y2 - y1) 식을 곱셈으로 변환하여 오차 방지
        // 부동소수점 오차를 고려해 매우 작은 값(EPSILON) 사용 권장되나, 문제 특성상 등호로도 통과되는 경우가 많음
        // 여기서는 안전하게 기울기 차이가 0인 경우를 체크
        if ((px - x1) * (y2 - y1) != (x2 - x1) * (py - y1)) {
            return false;
        }

        // 2. 범위 확인 (점이 두 끝점 사이에 존재하는지)
        if (Math.min(x1, x2) <= px && px <= Math.max(x1, x2) &&
            Math.min(y1, y2) <= py && py <= Math.max(y1, y2)) {
            return true;
        }
        
        return false;
    }
}