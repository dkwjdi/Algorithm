package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2206 {
	static class Point {
		int x, y, wallbreak, count;

		Point(int x, int y, int wallbreak, int count) {
			this.x = x;
			this.y = y;
			this.wallbreak = wallbreak;
			this.count = count;
		}

		Point(int i, int j) {
			// TODO Auto-generated constructor stub
		}
	}

	static int N;
	static int M;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		input();
		bfs(1, 1);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][2];
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split("");
			for (int j = 1; j <= M; j++)
				map[i][j] = Integer.parseInt(input[j - 1]);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 0, 1));
		visited[x][y][0] = true;
		visited[x][y][1] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.x == N && p.y == M) {
				System.out.println(p.count);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int wallbreak = p.wallbreak;
				int count = p.count;

				if (nx <= 0 || ny <= 0 || nx > N || ny > M)
					continue;

				if (map[nx][ny] == 1) { // 벽
					if (wallbreak == 0 && !visited[nx][ny][1]) {// 벽부셧면 벽다시 못부심
						visited[nx][ny][1] = true;
						queue.offer(new Point(nx, ny, 1, count + 1));
					}
				} else { // 0일 때
					if (!visited[nx][ny][wallbreak]) {
						queue.offer(new Point(nx, ny, wallbreak, count + 1));
						visited[nx][ny][wallbreak] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
