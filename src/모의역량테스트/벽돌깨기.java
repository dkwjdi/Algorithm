package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽돌깨기 {
	static int N, W, H, cnt, result;
	static int map[][], copymap[][];
	static HashSet<String> set;
	static Queue<int[]> queue =new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		map = new int[20][20];
		copymap = new int[20][20];

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;

			for (int i = 1; i <= H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						cnt++;
				}
			}
			 set = new HashSet<>();
			sb.append("#" + tc + " " + solve() + "\n");
			cnt = 0;

		}
		System.out.println(sb);
	}

	private static int solve() {
		for (int q = 1; q <= W; q++)
			for (int w = 1; w <= W; w++)
				for (int e = 1; e <= W; e++)
					for (int r = 1; r <= W; r++) {
						result = Math.min(result, dropbomb(q, w, e, r));
					}
		return result;
	}

	private static int dropbomb(int q, int w, int e, int r) {
		int tmpcnt = cnt;
		

		
		for (int i = 0; i <= H; i++) { // 배열복사
			for (int j = 0; j <= W; j++) {
				copymap[i][j] = map[i][j];
			}
		}

		int[] stone = { q, w, e, r };
		String t = "";
		for(int i=0;i<N;i++)
			t += stone[i];
		
		 if(set.contains(t))
	            return Integer.MAX_VALUE;
	        set.add(t);
		

		for (int i = 0; i < N; i++) { // 폭탄개수만큼
			for (int j = 0; j <= H; j++) { // 맨위에서 맨밑으로 떨어짐
				int size = copymap[j][stone[i]];
				if (size != 0) {
					if (size == 1) {
						copymap[j][stone[i]] = 0;
						tmpcnt--;
						break;
					}
					tmpcnt -= bomb(j, stone[i], size);
					break;
				}
			}
			down();
		}
		return tmpcnt;
	}

	private static void down() {
		for (int k = 0; k < H; k++) {
			for (int i = H; i > 0; i--) {
				for (int j = 1; j <= W; j++) {
					if (copymap[i][j] == 0 && copymap[i - 1][j] != 0) {
						copymap[i][j] = copymap[i - 1][j];
						copymap[i - 1][j] = 0;
					}
				}
			}
		}
	}

	private static int bomb(int x, int y, int size) {
		queue.clear();
		queue.offer(new int[] { x, y, size });
		copymap[x][y] = 0;
		int destroy = 1;
		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { -1, 1, 0, 0 };

		while (!queue.isEmpty()) {
			int[] start = queue.poll();
			for (int i = 0; i < 4; i++) { // 사방
				int nx = start[0];
				int ny = start[1];
				for (int j = 1; j < start[2]; j++) { // 크기만큼
					nx += dx[i];
					ny += dy[i];

					if (nx < 1 || ny < 1 || nx > H || ny > W)
						continue;

					if (copymap[nx][ny] != 0) {
						if (copymap[nx][ny] == 1) { // 1일때
							copymap[nx][ny] = 0;
							destroy++;
						} else { // 1보다 클 때
							destroy++;
							queue.offer(new int[] { nx, ny, copymap[nx][ny] });
							copymap[nx][ny] = 0;
						}
					}
				}
			}
		}
		return destroy;
	}
}
