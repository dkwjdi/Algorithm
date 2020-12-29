package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20057_마법사상어와토네이도 {
	static int N, map[][], result;
	static int dx[]= {0,1,0,-1};
	static int dy[]= {-1,0,1,0};
	static int percent[]= {1,1,2,2,5,7,7,10,10};
	static int movex[][]= {
			{-1,1,-2,2,0,-1,1,-1,1,0}, //좌
			{0,0,1,1,3,1,1,2,2,2}, //하
			{-1,1,-2,2,0,-1,1,-1,1,0}, //우
			{0,0,-1,-1,-3,-1,-1,-2,-2,-2} //상
	
	};
	static int movey[][]= {
			{0,0,-1,-1,-3,-1,-1,-2,-2,-2}, //좌
			{-1,1,-2,2,0,-1,1,-1,1,0}, //하
			{0,0,1,1,3,1,1,2,2,2}, //우
			{-1,1,-2,2,0,-1,1,-1,1,0} //상
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(1,0,0,0, N/2, N/2);
		System.out.println(result);

	}
	//nCnt 지금 한번에 몇 개 가는지 N-1번만큼 가야됨 
	//cnt nCnt값으로 2번 갔는지 N-1일떄는 3번 가야됨 ㅇ ㅋ?
	// d 방향 
	// dCnt 지금 d방향으로 몇번 갔는지 !
	
	private static void solve(int nCnt, int cnt, int d, int dCnt, int x, int y) {
		if(x==0 && y==0) return;
		
		//방향 바꿔주기 
		if(dCnt==nCnt) {
			if(++d==4) d=0;
			dCnt=0;
			cnt++;
		}
		if(cnt==2 && nCnt!=N-1) { // nCnt늘려주기 
			cnt=0;
			nCnt++;
		}
		
		int nx=x+dx[d];
		int ny=y+dy[d]; //토네이도 보낼 위치 
		
		int send=map[nx][ny];
		int outSend=0;
		
		for(int i=0; i<9; i++) {
			//모래가 옮겨질 좌표
			int sx=x+movex[d][i];
			int sy=y+movey[d][i];
			
			int plusSend=(int)(send*((double)percent[i]/100));
			outSend+=plusSend;
			if(sx<0|| sy<0|| sx>=N || sy>=N) {
				result+=plusSend; //밖으로 나가는거
				continue;
			}
			map[sx][sy]+=plusSend; //밖으로 안나가면 그 좌표에 더해줌 
		}
		if(x+movex[d][9]<0 || y+movey[d][9]<0||x+movex[d][9]>=N || y+movey[d][9]>=N) result+=send-outSend;
		else map[x+movex[d][9]][y+movey[d][9]]+=send-outSend; //남은거 a자리에 넣어주기 
		map[nx][ny]=0;
		
		solve(nCnt,cnt,d,dCnt+1,nx,ny);
	}
}
