package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1194_달이차오른다가자 {
	static class Point {
		int x, y, cnt, index;

		public Point(int x, int y, int index, int cnt) {
			this.x = x;
			this.y = y;
			this.index = index;
			this.cnt = cnt;
		}
	}

	static int N, M, sx, sy, result;
	static char map[][];
	static boolean visited[][][];
	static boolean key[];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[100][100];
		visited = new boolean[N][M][200];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					sx = i;
					sy = j;
				}
			}
		}

		if(!solve(sx, sy, 0)) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}

	private static boolean solve(int x, int y, int index) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 0, 0));
		visited[x][y][index] = true;

		while (true) {
			int size = queue.size();
			if (size == 0)
				return false;
			for (int i = 0; i < size; i++) {
				Point point = queue.poll();
				if (map[point.x][point.y] == '1') {
					result = point.cnt;
					return true;
				}

				for (int d = 0; d < 4; d++) {
					int nx = point.x + dx[d];
					int ny = point.y + dy[d];

					if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || visited[nx][ny][point.index]
							|| map[nx][ny] == '#')
						continue; // 범위 벗어나거나 맵이 #이면 스킵
					else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') { // 키 있으면 key배열 true
						int tmpindex = point.index | (1 << (map[nx][ny] - 96));
						queue.offer(new Point(nx, ny, tmpindex, point.cnt + 1));
						visited[nx][ny][tmpindex] = true;

					} else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') { //  큐 넣어줌
						if ((point.index & (1 << map[nx][ny] - 64)) == 0) continue; // 만약 없다면
						else { // 그 문제에 대한 열쇠가 있다면
							queue.offer(new Point(nx, ny, point.index, point.cnt + 1));
							visited[nx][ny][point.index] = true;
						}
					} else {
						queue.offer(new Point(nx, ny, point.index, point.cnt + 1));
						visited[nx][ny][point.index] = true;
					}

				}
			}
		}
	}

}
