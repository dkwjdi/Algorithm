package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����Ż�� {
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

		char copyMap[][] = copy(map); // �� ����
		int[] points = move(copyMap, xMove, yMove, rx, ry, bx, by, cnt);
		if (endFlag)
			return; // �������� ���ٸ� ���� dfs ����

		rx = points[0];
		ry = points[1];
		bx = points[2];
		by = points[3];

		// ���� ����̱�
		dfs(copyMap, cnt + 1, 0, -1, rx, ry, bx, by);
		// ������ ����̱�
		dfs(copyMap, cnt + 1, 0, 1, rx, ry, bx, by);
		// ���� ����̱�
		dfs(copyMap, cnt + 1, -1, 0, rx, ry, bx, by);
		// �Ʒ��� ����̱�
		dfs(copyMap, cnt + 1, 1, 0, rx, ry, bx, by);
	}

	private static int[] move(char[][] map, int xMove, int yMove, int rx, int ry, int bx, int by, int cnt) {
		int points[] = new int[4];
		boolean redFlag = false;
		boolean blueFlag = false;
		boolean redWallFlag = false; // �� �ε��ļ� �������!
		boolean blueWallFlag = false;

		while (true) {
			redWallFlag = false;
			blueWallFlag = false;
			int nrx = rx;
			int nry = ry;
			int nbx = bx;
			int nby = by;

			nrx += xMove; // �����̱�
			nry += yMove;

			nbx += xMove; // �����̱�
			nby += yMove;

			redWallFlag = wallCheck(nrx, nry, map);

			if (!redWallFlag) { // ���� �� �ƴ϶�� !
				if (map[nrx][nry] != 'O') { // ���� �ƴ϶��!
					// ���� �ƴϰ� ���۵� �ƴ� rx,ry �ű��, R�� �Ű���
					map[rx][ry] = '.';
					map[nrx][nry] = 'R';
					rx = nrx;
					ry = nry;
				} else { // ���� �ƴѵ� ���ۿ� ���Դٸ� ?
					map[rx][ry] = '.'; // �����ִ� �ڸ� ���ְ�
					redWallFlag = true; // ���̻� ����
					redFlag = true; // ������ ��

				}
			}

			blueWallFlag = wallCheck(nbx, nby, map);

			if (!blueWallFlag) { // ���� �� �ƴ϶�� !
				if (map[nbx][nby] != 'O') { // ���� �ƴ϶��!
					// ���� �ƴϰ� ���۵� �ƴ� rx,ry �ű��, R�� �Ű���
					map[bx][by] = '.';
					map[nbx][nby] = 'B';
					bx = nbx;
					by = nby;
				} else { // ���� �ƴѵ� ���ۿ� ���Դٸ� ?
					map[bx][by] = '.'; // �����ִ� �ڸ� ���ְ�
					blueWallFlag = true; // ���̻� ����
					blueFlag = true; // ������ ��

				}
			}
			if(blueFlag) {
				break;
			}
			if (redWallFlag && blueWallFlag)
				break; // �Ѵ� �������� ���ϸ� while�� ����
		}
		
		if(blueFlag && !redFlag) {
			endFlag=true;
		}

		if (redFlag && !blueFlag) { // �������� ����
			endFlag = true; // ������
			result = Math.min(result, cnt);
		} else if (redFlag && blueFlag) {
			endFlag = true; // �Ѵ� �������� �����ߵ���
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
