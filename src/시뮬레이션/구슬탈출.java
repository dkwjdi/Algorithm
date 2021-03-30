package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬탈출 {
	static int N, M, result;
	static char copyMap[][];
	static boolean endFlag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		int rx = 0, ry = 0;
		int bx = 0, by = 0;
		endFlag = false;
		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			map[i] = input.toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}

		dfs(map, 0, 0, 0, rx, ry, bx, by);
		result = result == Integer.MAX_VALUE ? -1 : result;
		System.out.println(result);
	}

	private static void dfs(char[][] map, int cnt, int xMove, int yMove, int rx, int ry, int bx, int by) {
		endFlag = false;
		if (cnt == 11)
			return;

		char copyMap[][] = copy(map); // 맵 복사
		int[] points = move(copyMap, xMove, yMove, rx, ry, bx, by, cnt);
		if (endFlag)
			return; // 빨간공만 들어갔다면 지금 dfs 멈춰

		rx = points[0];
		ry = points[1];
		bx = points[2];
		by = points[3];

		// 왼쪽 기울이기
		dfs(copyMap, cnt + 1, 0, -1, rx, ry, bx, by);
		// 오른족 기울이기
		dfs(copyMap, cnt + 1, 0, 1, rx, ry, bx, by);
		// 위로 기울이기
		dfs(copyMap, cnt + 1, -1, 0, rx, ry, bx, by);
		// 아래로 기울이기
		dfs(copyMap, cnt + 1, 1, 0, rx, ry, bx, by);
	}

	private static int[] move(char[][] map, int xMove, int yMove, int rx, int ry, int bx, int by, int cnt) {
		int points[] = new int[4];
		boolean redFlag = false;
		boolean blueFlag = false;
		boolean redWallFlag = false; // 벽 부딪쳐서 멈췄는지!
		boolean blueWallFlag = false;

		while (true) {
			redWallFlag = false;
			blueWallFlag = false;
			int nrx = rx;
			int nry = ry;
			int nbx = bx;
			int nby = by;

			nrx += xMove; // 움직이기
			nry += yMove;

			nbx += xMove; // 움직이기
			nby += yMove;

			redWallFlag = wallCheck(nrx, nry, map);

			if (!redWallFlag) { // 만약 벽 아니라면 !
				if (map[nrx][nry] != 'O') { // 구멍 아니라면!
					// 벽도 아니고 구멍도 아님 rx,ry 옮기고, R도 옮겨줌
					map[rx][ry] = '.';
					map[nrx][nry] = 'R';
					rx = nrx;
					ry = nry;
				} else { // 벽은 아닌데 구멍에 들어왔다면 ?
					map[rx][ry] = '.'; // 원래있던 자리 없애고
					redWallFlag = true; // 더이상 못감
					redFlag = true; // 빨간공 들어감

				}
			}

			blueWallFlag = wallCheck(nbx, nby, map);

			if (!blueWallFlag) { // 만약 벽 아니라면 !
				if (map[nbx][nby] != 'O') { // 구멍 아니라면!
					// 벽도 아니고 구멍도 아님 rx,ry 옮기고, R도 옮겨줌
					map[bx][by] = '.';
					map[nbx][nby] = 'B';
					bx = nbx;
					by = nby;
				} else { // 벽은 아닌데 구멍에 들어왔다면 ?
					map[bx][by] = '.'; // 원래있던 자리 없애고
					blueWallFlag = true; // 더이상 못감
					blueFlag = true; // 빨간공 들어감

				}
			}
			if(blueFlag) {
				break;
			}
			if (redWallFlag && blueWallFlag)
				break; // 둘다 움직이지 못하면 while문 끝냄
		}
		
		if(blueFlag && !redFlag) {
			endFlag=true;
		}

		if (redFlag && !blueFlag) { // 빨간공만 들어가면
			endFlag = true; // 끝내기
			result = Math.min(result, cnt);
		} else if (redFlag && blueFlag) {
			endFlag = true; // 둘다 들어갔ㄷ으니 끝내야도미
		}

		points[0] = rx;
		points[1] = ry;
		points[2] = bx;
		points[3] = by;

		return points;

	}

	private static boolean wallCheck(int x, int y, char[][] map) {
		if (map[x][y] == '#' || map[x][y] == 'R' || map[x][y] == 'B')
			return true;
		return false;
	}

	private static char[][] copy(char[][] map) {
		char copyMap[][] = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}

}
