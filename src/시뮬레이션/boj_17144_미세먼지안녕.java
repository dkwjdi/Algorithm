package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17144_미세먼지안녕 {
	// 왼족 ,오른쪽 , 위 ,아래
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int R, C, T, map[][], tmpmap[][], aircleanerx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		tmpmap = new int[R][C];
		int cleanerx = 0;

		for (int i = 0; i < R; i++) {
			String[] data = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(data[j]);
				if (map[i][j] == -1)
					aircleanerx = i - 1;
			}
		}

		for (int t = 0; t < T; t++) {
			diffuse();
			airclean();
		}

		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (((i == aircleanerx) || (i == aircleanerx + 1)) && j == 0)
					continue;
				result += map[i][j];
			}
		}
		System.out.println(result);
	}

	private static void airclean() {

		// 위쪽
		// 위로
		for (int i = aircleanerx - 2; i >= 0; i--) {
			map[i + 1][0] = map[i][0];
		}
		// 오른쪽
		for (int i = 1; i < C; i++) {
			map[0][i - 1] = map[0][i];
		}
		// 아래
		for (int i = 1; i <= aircleanerx; i++) {
			map[i - 1][C - 1] = map[i][C - 1];
		}
		// 왼쪽
		for (int i = C - 2; i >= 1; i--) {
			map[aircleanerx][i + 1] = map[aircleanerx][i];
		}
		map[aircleanerx][1] = 0;

		// 아래쪽
		// 아래로
		for (int i = aircleanerx + 3; i < R; i++) {
			map[i - 1][0] = map[i][0];
		}
		// 오른쪽
		for (int i = 1; i < C; i++) {
			map[R - 1][i - 1] = map[R - 1][i];
		}
		// 위로
		for (int i = R - 2; i >= aircleanerx + 1; i--) {
			map[i + 1][C - 1] = map[i][C - 1];
		}
		// 왼쪽
		for (int i = C - 2; i >= 1; i--) {
			map[aircleanerx + 1][i + 1] = map[aircleanerx + 1][i];
		}
		map[aircleanerx + 1][1] = 0;
	}

	private static void diffuse() {
		int mid = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1) { // 공기청정기, 0 자리 아니라면
					int tmp = map[i][j] / 5;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (nx < 0 || ny < 0 || nx >= R || ny >= C
								|| ((nx == aircleanerx || nx == aircleanerx + 1) && ny == 0))
							continue;
						tmpmap[nx][ny] += tmp;
						tmpmap[i][j] -= tmp;
					}
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += tmpmap[i][j];
				tmpmap[i][j] = 0;
			}
		}
	}

}
