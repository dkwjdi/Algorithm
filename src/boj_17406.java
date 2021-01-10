import java.util.Arrays;
import java.util.Scanner;

public class boj_17406 {

	public class Point {
		int r, c, s;

		public Point() {
		}

		public Point(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

	}

	static int numbers[], N, row, col, map[][];
	static boolean isSelected[];
	static Point[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		N = sc.nextInt();

		map = new int[row + 1][col + 1];
		isSelected = new boolean[N + 1];
		numbers = new int[N];
		p = new Point[N];

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			p[i].r = sc.nextInt();
			p[i].c = sc.nextInt();
			p[i].s = sc.nextInt();
		}

		permutation(0);
	}

	private static void permutation(int cnt) { // cnt: npr중 r의 역활 (몇개를 뽑을 것인지)

		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			arraySpin();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (isSelected[i] == true)
				continue;

			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}

	}

	private static void arraySpin() {
		int[][] copymap = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) { // 맵복사
			copymap[i] = map[i];
		}

		int First = 0;

		for (int i = 0; i < N; i++) { // r,c,s값 꺼내기
			
			//위
			for (int q = p[i].c + p[i].s; q >= p[i].c - p[i].s; q--) {
				if (q == p[i].c + p[i].s) { // 마지막번호
					First = copymap[p[i].r - p[i].s][q];
				} else {
					copymap[p[i].r - p[i].s][q + 1] = copymap[p[i].r - p[i].s][q];
				}
			}
			
			//오른쪽
			int Second=0;
			for (int q = p[i].r + p[i].s; q > p[i].r - p[i].s; q--) {
				if (q == p[i].r + p[i].s) { // 마지막번호
					Second = copymap[p[i].r + p[i].s][p[i].c+p[i].s];
				} else {
					copymap[p[i].r - p[i].s][q + 1] = copymap[p[i].r - p[i].s][q];
				}
			}

		}
		
		

	}

}
