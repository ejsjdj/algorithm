import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int king, queen, rook, bishop, knight, pown;
		
		king = sc.nextInt();
		queen = sc.nextInt();
		rook = sc.nextInt();
		bishop = sc.nextInt();
		knight = sc.nextInt();
		pown = sc.nextInt();
		
		if (king == 1) {
			System.out.print(0 + " ");
		} else {
			System.out.print(1-king + " ");
		}
		
		if (queen == 1) {
			System.out.print(0 + " ");
		} else {
			System.out.print(1-queen + " ");
		}
		
		if (rook == 2) {
			System.out.print(0 + " ");
		} else {
			System.out.print(2-rook + " ");
		}
		
		if (bishop == 2) {
			System.out.print(0 + " ");
		} else {
			System.out.print(2-bishop + " ");
		}
		
		if (knight == 2) {
			System.out.print(0 + " ");
		} else {
			System.out.print(2-knight + " ");
		}
		
		if (pown == 8) {
			System.out.print(0 + " ");
		} else {
			System.out.print(8-pown + " ");
		}
		
		sc.close();
		
	}

}