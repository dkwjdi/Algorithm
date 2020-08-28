package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class boj_1987 {
	static int R, C, max ;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static char[][] map;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		input();
		dfs(0,0,1);
		System.out.println(max);
	}

	private static void dfs(int x, int y, int cnt) {
		
		if(max<cnt) max = cnt;
		if (cnt == 26)return ;
			 // 만약 알파벳 다 봤으면 끝
		
		isSelected[map[x][y] - 'A'] = true; // 방문체크
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C || isSelected[map[nx][ny] - 'A'])continue;
			dfs(nx, ny, cnt+1);
			isSelected[map[nx][ny]-'A']=false;
		}
		return;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		isSelected = new boolean[30];
		map = new char[R][];
		for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
	}
}
