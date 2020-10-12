package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 디저트카페 {
	static int []dx= {1,1,-1,-1};
	static int []dy= {1,-1,-1,1};
	static int N,max, map[][], sx, sy;
	static boolean visit[] = new boolean[110]; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			map= new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			max=0;
			int result=solve();
			if(result==0) result=-1;
			sb.append("#" + tc + " " + result + "\n");
		}
		
		System.out.println(sb);
	}

	private static int solve() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sx=i;
				sy=j;
				dfs(i,j,0,0);
			}
		}
		return max;
	}

	private static void dfs(int i, int j, int d, int sum) {
		if(sx==i && sy==j && d==3) { //제자리로 왔을 때
			max=Math.max(max, sum);
			return ;
		}
		if(d==4) return ;
		if(d==3 && sum<3) return;
		
		
		int nx=i+dx[d];
		int ny=j+dy[d];
		
		if(nx<1 || ny<1 || nx>N ||ny>N) return ;
		
		if(visit[map[nx][ny]]) return ;
		
		visit[map[nx][ny]]=true;
		dfs(nx,ny,d,sum+1);
		dfs(nx,ny,d+1,sum+1);
		visit[map[nx][ny]]=false;
		
		
	}

}
