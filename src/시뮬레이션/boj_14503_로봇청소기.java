package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503_로봇청소기 {
	static class Info {
		int x, y, d;

		public Info(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int N, M, map[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		System.out.println("#");
		System.out.println("#");
		System.out.println("#");
		System.out.println("#");
		for(int i=0; i<99; i++) {
			System.out.println("zz");
		}
		System.out.println("#");
		System.out.println("#");
		System.out.println("#");
		System.out.println("#");
		System.out.println("#");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine(), " ");
		Info robot = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		if (robot.d == 1) robot.d = 3;
		else if (robot.d == 3) robot.d = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solve(robot));
	}

	private static int solve(Info robot) {
		boolean backFlag=false;
		int cnt=0;
		loop: while (true) {
			
			// 1번
			if(!backFlag) {
				map[robot.x][robot.y] = 2;
				cnt++;
			}
			backFlag=false;

			// 2-b
			for (int i = 1; i <= 4; i++) {
				int nx = robot.x + dx[(robot.d + i) % 4];
				int ny = robot.y + dy[(robot.d + i) % 4];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 1 || map[nx][ny] == 2) continue;
				// 2-a
				robot.x = nx;
				robot.y = ny;
				robot.d = (robot.d + i) % 4;
				continue loop;
			}
			// 2-c, d
			if(!backCheck(robot)) return cnt;
			else backFlag=true;
		}
	}

	private static boolean backCheck(Info robot) {
		int nx=robot.x-dx[robot.d];
		int ny=robot.y-dy[robot.d];
		
		if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 1 ) return false;
		
		robot.x=nx;
		robot.y=ny;
		return true;
	}
}
