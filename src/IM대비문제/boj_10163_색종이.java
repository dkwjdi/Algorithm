package IM대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10163_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[103][103];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			fiils(x, y, width, height, map, i);
		}

		int[] cnt = new int[n + 1];

		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if (map[i][j] != 0)
					cnt[map[i][j]]++;
			}

		}
		for (int i = 1; i <= n; i++) {
			System.out.println(cnt[i]);
		}

	}

	private static void fiils(int x, int y, int width, int height, int[][] map, int number) {
		for (int i = x; i < x + width; i++) {
			for (int j = y; j < y + height; j++) {
				map[i][j] = number;
			}
		}
	}
}
