package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2239_스도쿠 {
	static int map[][];
	static int row;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				int data = input.charAt(j) - '0';
				map[i][j] = data;
			}
		}
		dfs(0, 0);
	}

	private static void dfs(int i, int j) {
		if (i == 8 && j == 9) {
			print();
			System.exit(0);
			return;
		}
		if (j == 9) {
			j = 0; i++;
		}
		if (map[i][j] != 0) {
			dfs(i, j + 1); // 0아니면 넘김 
			return;
		}

		// 자리가 0 이면 이까지 온다.
		for (int n = 1; n <= 9; n++) {
			if (!rowCheck(i, j, n)) continue;
			if (!colCheck(i, j, n)) continue;
			if (!recCheck(i, j, n)) continue;
				
			// 여기에 하나도 안걸리면
			map[i][j] = n;
			dfs(i, j + 1);
			map[i][j]=0;
		}

	}

	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean recCheck(int i, int j, int n) {
		int r = 0, c = 0;
		if (i <= 2) r = 0;
		else if (i <= 5) r = 3;
		else r = 6;
		
		if (j <= 2) c = 0;
		else if (j <= 5) c = 3;
		else c = 6;
		
		for (int q=r; q<r+3; q++) {
			for (int w=c; w<c+3; w++) {
				if (map[q][w] == n)
					return false;
			}
		}
		return true;
	}

	private static boolean colCheck(int i, int j, int n) {
		for (int r = 0; r < 9; r++) {
			if (map[r][j] == n)
				return false;
		}
		return true;
	}

	private static boolean rowCheck(int i, int j, int n) {
		for (int c = 0; c < 9; c++) {
			if (map[i][c] == n)
				return false;
		}
		return true;
	}

}
