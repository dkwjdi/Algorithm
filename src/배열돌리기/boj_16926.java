package 배열돌리기;

import java.util.Scanner;

public class boj_16926 {
	static int N, M, R, array[][];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		input();
		for (int i = 0; i < R; i++) {
			Rotate();
		}
		print();
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void Rotate() {
		int size = Math.min(N, M) / 2;

		for (int i = 0; i < size; i++) { //
			int temp = array[i][i];
			int lx = i, ly = i;
			int index = 0;
			while (index < 4) {
				int nx = lx + dx[index];
				int ny = ly + dy[index];

				if (nx >= i && ny >= i && nx < N - i && ny < M - i) {
					array[lx][ly] = array[nx][ny];

					lx = nx;
					ly = ny;

				} else {
					index++;
				}
			}

			array[i + 1][i] = temp;

		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		array = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				array[i][j] = sc.nextInt();
			}
		}
	}

}
