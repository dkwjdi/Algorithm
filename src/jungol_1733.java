import java.util.Scanner;

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class jungol_1733 {
	// 좌우 상하 왼쪽위,오른쪽아래 오른쪽위왼쪽아래
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };
	static int count, resultx, resulty, stone,map[][];

	public static void main(String[] args) {
		input();
		if (!solve()) System.out.println(0);
	}

	private static boolean solve() {
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (map[i][j] != 0) {
					if (omokcheck(i, j, map[i][j])) {
						System.out.println(map[i][j]);
						if (map[i][j] != 0)
							System.out.println(resultx + " " + resulty);
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean omokcheck(int i, int j, int stone) {
		resultx = i;
		resulty = j;
		count = 1;

		for (int k = 0; k < 2; k++) { // 좌 우 확인
			int nx = i;
			int ny = j;
			while (true) {
				nx += dx[k];
				ny += dy[k];
				if (nx < 1 || ny < 1 || nx > 19 || ny > 19 || map[nx][ny] != stone) {
					break;
				}
				if (resulty > ny) {
					resultx = nx;
					resulty = ny;
				}
				count++;
			}
		}
		if (count == 5)
			return true;
		resultx = i;
		resulty = j;
		count = 1;
		for (int k = 2; k < 4; k++) { // 상하 확인
			int nx = i;
			int ny = j;
			while (true) {
				nx += dx[k];
				ny += dy[k];
				if (nx < 1 || ny < 1 || nx > 19 || ny > 19 || map[nx][ny] != stone) {
					break;
				}
				if (resulty > ny) {
					resultx = nx;
					resulty = ny;
				}
				count++;
			}
		}
		if (count == 5)
			return true;
		resultx = i;
		resulty = j;
		count = 1;
		for (int k = 4; k < 6; k++) { // 대각 1 확인
			int nx = i;
			int ny = j;
			while (true) {
				nx += dx[k];
				ny += dy[k];
				if (nx < 1 || ny < 1 || nx > 19 || ny > 19 || map[nx][ny] != stone) {
					break;
				}

				if (resulty > ny) {
					resultx = nx;
					resulty = ny;
				}
				count++;
			}
		}
		if (count == 5)
			return true;
		resultx = i;
		resulty = j;
		count = 1;
		for (int k = 6; k < 8; k++) { // 대각 2확인
			int nx = i;
			int ny = j;
			while (true) {
				nx += dx[k];
				ny += dy[k];
				if (nx < 1 || ny < 1 || nx > 19 || ny > 19 || map[nx][ny] != stone) {
					break;
				}
				if (resulty > ny) {
					resultx = nx;
					resulty = ny;
				}
				count++;
			}
		}
		if (count == 5)
			return true;
		count = 1;
		return false;
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		map = new int[21][21];
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				map[i][j] = sc.nextInt();
			}
		}

	}

}
