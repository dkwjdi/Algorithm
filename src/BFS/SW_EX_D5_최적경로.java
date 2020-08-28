package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_EX_D5_최적경로 {
	static int T, N,tc, numbers[], min=999999999;
	static boolean isSelected[];
	static Point home, workspace, custom[];
	static class Point {
		int x, y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
	}

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for ( tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			StringTokenizer st= new StringTokenizer(input);
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			workspace = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			numbers = new int[N];
			isSelected = new boolean[N + 1];
			custom = new Point[N];
			for (int i = 0; i < N; i++) {
				custom[i]=new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			permutation(0);
			sb.append("#"+tc+" "+min+"\n");
			min=999999999;
		}
		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if (cnt == N) {
			min =Math.min(solve(), min);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i] == true)continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static int solve() {
		
		int distacne =Math.abs(custom[numbers[0]].x-workspace.x)+Math.abs(custom[numbers[0]].y-workspace.y);
		for(int i=1; i<N; i++) {
			distacne+=Math.abs(custom[numbers[i]].x-custom[numbers[i-1]].x)+Math.abs(custom[numbers[i]].y-custom[numbers[i-1]].y);
			if(min<=distacne) break;
		}
		distacne+= Math.abs(home.x-custom[numbers[N-1]].x)+Math.abs(home.y-custom[numbers[N-1]].y);
		return distacne;
	}
}
