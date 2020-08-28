/**
입력
5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1

출력
12
 */

import java.util.Scanner;

public class boj_17406_쌤 {
	private static int N;
	private static int M;
	private static int K;
	private static int[][] map;  // 초기 
	private static int[][] mapClone;  // 초기 맵을 복사 
	private static int[][] arr;  // 회전정보 : 초기 위치(행, 열, 크기)
	private static int[][] tempArr;
	private static boolean[] v;  // 순열에 사용
	private static int result;
	private static int min;

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N + 1][M + 1];
		mapClone = new int[N + 1][M + 1];
		arr = new int[K][];
		tempArr = new int[K][];
		v = new boolean[K];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < K; i++) { //회전정보
			arr[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};  // r, c, s
		}

		// 순열 구하기
		result = Integer.MAX_VALUE;
		min = Integer.MAX_VALUE;
		perm(0);
		System.out.println(result);

	} // end of main

	/**
	 * 회전 연산에 대한 순열 구하기
	 * 
	 * @param len
	 */
	private static void perm(int len) {
		if (len == K) {
			// 배열돌리고 최솟값 구하는 곳 구현
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					mapClone[i][j] = map[i][j];
				}
			}
			// 순열이 준비되었다면 해당 순열의 회전 연산 처리하기
			solve();
			result = Math.min(result, min);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				tempArr[len] = arr[i];
				perm(len + 1);
				v[i] = false;
			}
		}
	}

	private static void solve() {
		// tempArr사용
		min = Integer.MAX_VALUE;
		//tempArr -> arr Rotate 한테 회전 내용 준다
		for (int i = 0; i < tempArr.length; i++) {
			arrRotate(tempArr[i]);
		}

		// 배열을 다 돌린 후의 각 행의 최소값 찾
		int sum = 0;
		for (int j = 1; j <= N; j++) {
			sum = 0;
			for (int k = 1; k <= M; k++) {
				sum += mapClone[j][k];
			}
			min = Math.min(sum, min);
		}
	}

	// 배열 회전 시키기
	private static void arrRotate(int[] d) {
		int r = d[0];
		int c = d[1];
		for (int s = 1; s <= d[2]; s++) {
			int prevV = -1;
			int initR = -1, initC = -1;  // 맨 처음 데이터를 기억하고 나중에 회전이 끝났을때 처음 위치의 데이터를 변경
			// (r-s, c-s) -> (r-s, c+s)
			for (int x = r - s, y = c - s; y <= c + s; y++) {
				if (prevV == -1) {
					initR = x;
					initC = y;
					prevV = mapClone[x][y];
				} else {
					int temp = prevV;
					prevV = mapClone[x][y];
					mapClone[x][y] = temp;
				}
			}
			// (r-s+1, c+s) -> (r+s, c+s)
			for (int x = r - s + 1; x <= r + s; x++) {
				int temp = prevV;
				prevV = mapClone[x][c + s];
				mapClone[x][c + s] = temp;
			}
			// (r+s, c+s-1) -> (r+s, c-s)
			for (int y = c + s - 1; y >= c - s; y--) {
				int temp = prevV;
				prevV = mapClone[r + s][y];
				mapClone[r + s][y] = temp;
			}
			// (r+s-1, c-s) -> (r-s+1, c-s)
			for (int x = r + s - 1; x >= r - s + 1; x--) {
				int temp = prevV;
				prevV = mapClone[x][c - s];
				mapClone[x][c - s] = temp;
			}
			mapClone[initR][initC] = prevV;
		}
	}
}