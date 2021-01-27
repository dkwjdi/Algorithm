package 시뮬레이션_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14499_주사위굴리기 {
	static int N,M,x,y,K,map[][],move[],dice[];
	static int dx[]= {0,0,0,-1,1};
	static int dy[]= {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map= new int[N][M];
		move=new int[K];
		dice=new int[6];
		
		//맵 
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//주사위 이동 방향
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			move[i]=Integer.parseInt(st.nextToken());
		}
		
		solve(sb);
		System.out.println(sb.toString());
		
	}
	private static void solve(StringBuilder sb) {
		
		for(int i=0; i<K; i++) { //주사위의 이동만큼
			int dir=move[i];
			
			//x,y좌표 이동
			int nx=x+dx[dir];
			int ny=y+dy[dir];
			
			if(nx<0 || ny<0 || nx>=N || ny>=M) continue; //범위넘어가면 skip
			
			x=nx; //범위 안넘어가니까 x,y바꿔주기
			y=ny;
			
			if(dir==1 || dir==2) { //1번 2번은  위 좌 아래 우 앞 뒤 
				int []copyDice= {dice[0],dice[3],dice[5],dice[2],dice[4],dice[1]};
				rollTheDice(copyDice,dir);
				rearrange(copyDice,dir);
				
			}
			else { //3번 4번은 앞 위 뒤 아래 좌 우 
				int []copyDice= {dice[4],dice[0],dice[1],dice[5],dice[3],dice[2]};
				rollTheDice(copyDice,dir);
				rearrange(copyDice,dir);
			}
			
			if(map[x][y]==0) { //이동한 칸이 0 이면 -> 주사위 바닥면에 쓰인수가 칸에 복사
				map[x][y]=dice[5];
			}
			else { //이동한칸이 0이 아니면 칸의 수가 주사위로 들어가고 칸은 0
				dice[5]=map[x][y];
				map[x][y]=0;
			}
			sb.append(dice[0]+"\n");
		}
		
	}
	private static void rearrange(int[] copyDice, int dir) {
		// 원래 주사위 ->>> 위 뒤 오 왼 앞 아래   
		if(dir==1 || dir==2) { //1번 2번은  위 좌 아래 우 앞 뒤  
			dice[0]=copyDice[0];
			dice[1]=copyDice[5];
			dice[2]=copyDice[3];
			dice[3]=copyDice[1];
			dice[4]=copyDice[4];
			dice[5]=copyDice[2];
		}
		else {//3번 4번은 앞 위 뒤 아래 좌 우
			dice[0]=copyDice[1];
			dice[1]=copyDice[2];
			dice[2]=copyDice[5];
			dice[3]=copyDice[4];
			dice[4]=copyDice[0];
			dice[5]=copyDice[3];
		}
	}
	private static void rollTheDice(int[] copyDice, int dir) {
		if(dir==1||dir==3) { //1번, 3번은 오른쪽으로 
			int num=copyDice[3];
			for(int i=3; i>0; i--) copyDice[i]=copyDice[i-1];
			copyDice[0]=num;
		}
		else { //2번 ,4번은 왼쪽으로
			int num=copyDice[0];
			for(int i=0; i<3; i++) copyDice[i]=copyDice[i+1];
			copyDice[3]=num;
		}
	}
}
