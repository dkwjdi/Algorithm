package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bjo4936 {

	static int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dy = { 1, -1, 0, 0, -1, 1, -1, 1 };
	static int[][] map;
	static boolean[][] visit;
	static int N, M;

	public static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			
			N = sc.nextInt();// 5
			M = sc.nextInt();// 4

			if (N == 0 && M == 0) break;
			
			map = new int[M][N];
			visit = new boolean[M][N];

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int cnt=0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && visit[i][j]==false) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
 
	private static void bfs(int x, int y ) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x,y));
		visit[x][y] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == 1 && visit[nx][ny] == false) {
					visit[nx][ny] = true;
					queue.offer(new Point(nx,ny));
				}
			}

		}

	}

}
