package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_20056_마법사상어와파이어볼 {
	static class Fire {
		int x, y, m, s, d;

		public Fire(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int [][]div4 = {{0,2,4,6}, {1,3,5,7}};
	static int N, M, K;
	static List<Fire> list = new ArrayList<>();
	static List<Fire> [][]map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new Fire(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		
		map = new List[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=new ArrayList<>();
			}
		}

		System.out.println(solve());

	}

	private static int solve() {

		for (int t = 0; t < K; t++) {
			
			int size=list.size();
			for(int i=0; i<size; i++) { //다 옮겨주고
				Fire fire = list.remove(0);
				move(fire);
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j].size()==1) { //한개일 대 list에 그냥 넣어줌
						Fire fire=map[i][j].remove(0);
						list.add(new Fire(fire.x,fire.y,fire.m,fire.s,fire.d));
					}
					else if(map[i][j].size()<2) continue;  //만약 맵에 2개 밑으로면 그냥 넘김
					
					//만약 2개 이상이라면 
					int divM=0;
					int divS=0;
					int divD=0;
					
					int divSize=map[i][j].size();
					int even=0;
					
					for(int k=0; k<divSize; k++) {
						Fire divFire=map[i][j].remove(0);
						divM+=divFire.m;
						divS+=divFire.s;
						if(divFire.d%2==0) even++;
					}
					
					divM/=5;
					if(divM==0) continue;
					divS=(divS)/divSize;
					
					int check=1;
					if(even==divSize || even==0)  check=0; //모두 짝수개이면
					
					
					for(int input=0; input<4; input++) { // 4개로 나뉘어짐
						list.add(new Fire(i,j,divM,divS,div4[check][input]));
					}
				}
			}
		}
		int sum=0;
		for(Fire fire : list) {
			sum+=fire.m;
		}
		return sum;
	}

	private static void move(Fire fire) {
		int nx = (fire.x + N + (dx[fire.d] * (fire.s % N))) % N;
		int ny = (fire.y + N + (dy[fire.d] * (fire.s % N))) % N;
		fire.x=nx;
		fire.y=ny;
		map[nx][ny].add(fire);
	}
}
