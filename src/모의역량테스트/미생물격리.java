package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 미생물격리 {
	static class Info implements Comparable<Info> {
		int x, y, num, dir;

		public Info(int x, int y, int num, int dir) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public int compareTo(Info o) {
			return o.num - this.num; // 미생물 수 기준으로 정렬
		}
	}

	static PriorityQueue<Info> bugList;
	static int dx[] = { -1, 0, 1, 0 }; // 상 좌 하 우
	static int dy[] = { 0, -1, 0, 1 };
	static int nummap[][], dirmap[][];
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			bugList = new PriorityQueue<>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				dir--;
				if (dir == 1) dir = 2;
				else if (dir == 2) dir = 1;

				bugList.offer(new Info(x, y, num, dir));
			}
			System.out.println("#" + tc + " " + solve());

		}
	}

	private static int solve() {
		for (int t = 1; t <= M; t++) {
			nummap=new int[N][N];
			dirmap=new int[N][N];

			int size = bugList.size();

			for (int i = 0; i < size; i++) {// 1. 이동하기
				Info bugMove = bugList.poll();
				int nx = bugMove.x;
				int ny = bugMove.y;

				nx += dx[bugMove.dir]; // x이동하고
				ny += dy[bugMove.dir]; // y이동

				if (nx < 1 || ny < 1 || nx > N - 2 || ny > N - 2) { // 약품 칠해진 곳 도착하면
					bugMove.dir = (bugMove.dir + 2) % 4; // 방향 반대로 바꾸고
					bugMove.num /= 2; // 갯수 반으로 줄이고
				}

				if (nummap[nx][ny] == 0) { // 합쳐주기
					dirmap[nx][ny] = bugMove.dir; // 비어 있다면 미생물수로 정렬했으니 바로 방향넣고
				}
				nummap[nx][ny] += bugMove.num; // 그다음 미생물개수 더해줌
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (nummap[i][j] == 0)
						continue;
					bugList.offer(new Info(i, j, nummap[i][j], dirmap[i][j])); //다시 큐에 넣어줌
				}
			}
		}
		int sum=0;
		while(!bugList.isEmpty()) {
			sum+=bugList.poll().num;
		}
		return sum;
	}
}
