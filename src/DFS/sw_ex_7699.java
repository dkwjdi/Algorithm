package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_ex_7699 {

	static int R, C, max;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][];
			visited = new boolean[26];
			max = 0;
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			visited[map[0][0]-'A']=true;
			go(0,0,1);
			System.out.println("#"+t+" "+max);

		}

	}

	public static void go(int r, int c, int cnt) {

		visited[map[r][c]-'A']=true;
		
		if(max<cnt) max =cnt;
		if(max==26) return;
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(nr<0 || nr>=R || nc<0 || nc>=C||visited[map[nr][nc]-'A'] )continue;
		
			go(nr,nc,cnt+1);
		}
		visited[map[r][c]-'A']=false;
		
		
		
	}
	// bfs가 절대적으로 유리 - 가중치가 없는 그래프에서 최단경로를 구할 때
	// dfs가 절대적으로 유리

}
