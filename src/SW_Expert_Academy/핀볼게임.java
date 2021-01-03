package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 핀볼게임 {
	static class wormHole {
		int x, y, no;
		public wormHole(int x, int y, int no) {
			this.x = x;
			this.y = y;
			this.no = no;
		}
	}
	static int N, map[][];
	static int dx[]= {-1,0,1,0}; //상 좌 하 우 
	static int dy[]= {0,-1,0,1};
	static HashMap<Integer, List<wormHole>> wormHoleList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			wormHoleList= new HashMap<Integer, List<wormHole>>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 6) {// 웜홀
						if (!wormHoleList.containsKey(map[i][j])) 
							wormHoleList.put(map[i][j], new ArrayList<>());
						wormHoleList.get(map[i][j]).add(new wormHole(i, j, map[i][j]));
					}
				}
			}
			System.out.println("#"+tc+" "+solve());
		}
	}

	private static int solve() {
		int score=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]!=0) continue;  //0 아니면 skip
				
				for(int d=0; d<4; d++) { //4 방향 돌아가면서 게임 시작
					score=Math.max(score, gameStart(i,j,d)); // x, y , 방향 
				}
			}
		}
		return score;
	}

	private static int gameStart(int x, int y, int dir) {
		int score=0;
		int nx=x;
		int ny=y;
		
		while(true) {
			nx+=dx[dir]; //핀볼 이동
			ny+=dy[dir];
			
			if(nx==x && ny==y) return score;
			
			if(nx<0 || ny<0 || nx>=N || ny>=N) { //벽 부딪치면
				dir=(dir+2)%4; //방향반대
				score++; //스코어 증가
				continue;
			}
			
			if(map[nx][ny]>=1 && map[nx][ny]<=5) { //1~5번에 부딪히면
				dir=changeDir(nx,ny,map[nx][ny],dir);
				score++;
			}
			else if(map[nx][ny]==-1) return score; //블랙홀만나면
			else if(map[nx][ny]>5) { //웜홀
				int no=map[nx][ny];
				//System.out.println(no);
				
				for(int i=0; i<2; i++) { //같은 번호의 다른좌표 웜홀로 이동
					int wormHolex=wormHoleList.get(no).get(i).x;
					int wormHoley=wormHoleList.get(no).get(i).y;
					if(wormHolex!=nx || wormHoley!=ny) {
						nx=wormHolex;
						ny=wormHoley;
						break;
					}
				}
			}
		}
	}

	private static int changeDir(int x, int y, int shape, int dir) {
		// 0 1 2 3
		// 상 좌 하 우
		if(shape==1) {
			if(dir==3 || dir==0) dir=(dir+2)%4; // 오른쪽, 위 
			else if(dir==1) dir=0;
			else dir=3;
		}
		else if(shape ==2) {
			if(dir==2 || dir==3) dir=(dir+2)%4; // 오른쪽, 아래
			else if(dir==0) dir=3;
			else dir=2;
		}
		else if(shape ==3) {
			if(dir==1 || dir==2) dir=(dir+2)%4; // 왼쪽, 아래
			else if(dir==0) dir=1;
			else dir=2;
		}
		else if(shape ==4) {
			if(dir==0 || dir==1) dir=(dir+2)%4; // 왼쪽, 위
			else if(dir==3) dir=0;
			else dir=1;
		}
		else if(shape ==5) {
			 dir=(dir+2)%4;
		}
		return dir;
	}

}
