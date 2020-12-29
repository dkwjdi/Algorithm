package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_19236_청소년상어 {
	static int []dx= {-1,-1,0,1,1,1,0,-1};
	static int []dy= {0,-1,-1,-1,0,1,1,1};
	static int result;
	static class Info{
		int x,y,dir;
		public Info(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int map[][]=new int[4][4];
		HashMap<Integer, Info> fishList= new HashMap<>();
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int num=Integer.parseInt(st.nextToken());
				int dir=Integer.parseInt(st.nextToken());
				
				map[i][j]=num;
				fishList.put(num, new Info(i,j,dir-1));
			}
		}
		
		Info tmp=fishList.get(map[0][0]);
		int fishNo=map[0][0];
		Info shark=new Info(tmp.x,tmp.y,tmp.dir);
		fishList.remove(map[0][0]);
		map[0][0]=-1;
		solve(shark,fishList,map,fishNo);
		System.out.println(result);
		
	}
	private static void solve(Info shark, HashMap<Integer, Info> fishList, int[][] map,int sum) {
		//System.out.println(sum);
		result=Math.max(result, sum);

		//물고기 이동부터
		fishMove(map,fishList);
		
		//상어 dfs로 보내기
		for(int d=1; d<=3; d++) { //상어 아무리 많이 가도 3칸 밖에 못감 
			int nx=shark.x+dx[shark.dir]*d;
			int ny=shark.y+dy[shark.dir]*d;
			
			if(nx<0 || ny<0 || nx>=4 ||ny>=4 ) break; //범위 벗어나거나  스킵
			
			if(map[nx][ny]==0) continue; //물고기 없으면 못감 
			else { //물고기가 있으면 들어가야됨 
				
				HashMap<Integer , Info> copyFishList= new HashMap<>();
				for(int no : fishList.keySet()) {
					copyFishList.put(no, new Info(fishList.get(no).x, fishList.get(no).y, fishList.get(no).dir));
				}
				int fishNo=map[nx][ny]; //삭제할 물고기 번호
				copyFishList.remove(fishNo);
				Info fish=fishList.get(fishNo); //삭제한 물고기 정보 
				int copy[][]=new int[4][4];
				for(int i=0; i<4; i++) {
					for(int j=0; j<4; j++) {
						copy[i][j]=map[i][j];
					}
				};
				copy[shark.x][shark.y]=0; //원래 상어자리 0
				copy[nx][ny]=-1; //새로운 상어자리 -1
				solve(new Info(nx,ny,fish.dir), copyFishList, copy, sum+fishNo);
				
			}
			
		}
				
		
	}
	private static void fishMove(int[][] map, HashMap<Integer, Info> fishList) {
		for(int i=1; i<=16; i++) {//번호작은거부터
			if(!fishList.containsKey(i)) continue; //이미 잡아먹혔으면 다음 
			Info fish=fishList.get(i);
			
			for(int d=0; d<8; d++) {
				int dir=(fish.dir+d)%8;
				int nx=fish.x+dx[dir];
				int ny=fish.y+dy[dir];
				
				if(nx<0 || ny<0 || nx>=4 ||ny>=4 || map[nx][ny]==-1) continue; //범위 벗어나거나 상어 잇으면 스킵
				
				//갈 수 있으면 물고기 map에서 번호 바꾸고 fishList에서도 바꿔주기 
				fish.dir=dir; //일단 물고기 방향부터 바꿔주고
				
				if(map[nx][ny]!=0 ) { //만약 물고기 있어서 방향 바꿔야 한다면
					Info tmp=fishList.get(map[nx][ny]);
					fishList.put(map[nx][ny], new Info(fish.x,fish.y,tmp.dir));
					fishList.put(map[fish.x][fish.y], new Info(nx,ny,fish.dir));
					
					int num=map[nx][ny];
					map[nx][ny]=map[fish.x][fish.y];
					map[fish.x][fish.y]=num;
				}
				else if(map[nx][ny]==0) { //물고기 없을 때 그냥 map에서 내꺼지우고 내꺼 넣고 list바꿔주기 
					fishList.put(map[fish.x][fish.y], new Info(nx,ny,fish.dir));
					map[nx][ny]=map[fish.x][fish.y];
					map[fish.x][fish.y]=0;
				}
				break;
				
			}
		}
		
		
	}

}
