package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	static class Cell{
		int x,y,hp,active,dead;
		public Cell(int x, int y, int hp, int active, int dead) {
			this.x = x;
			this.y = y;
			this.hp = hp;
			this.active = active;
			this.dead = dead;
		}
	}
	static int []dx= {0,0,-1,1};
	static int []dy= {-1,1,0,0};
	static int map[][],N,M,K;
	static List <Cell> cellList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			cellList = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			map = new int[N+(2*K)+1][M+(2*K)+1];
			
			for(int i=0; i<N; i++) {
				 st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i+K][j+K]=Integer.parseInt(st.nextToken());
					if(map[i+K][j+K]!=0) cellList.add(new Cell(i+K, j+K, map[i+K][j+K], 0,0));
				}
			}
			System.out.println("#"+tc+" "+solve());
		}
		
	}
	
	private static int solve() {
		int time=0;
		
		while(true) {
			time++;
			cellBfs();
			cellDead();
			if(time==K) return cellList.size();
		}
		
	}

	private static void cellDead() {
		int size=cellList.size();
		for(int i=size-1; i>=0 ; i--) {
			Cell cell=cellList.get(i);
			if(cell.dead==0 && cell.active==cell.hp) cellList.remove(i);
		}
		
	}

	private static void cellBfs() {
		
		 List <Cell> newCellList = new ArrayList<>();
		PriorityQueue<Cell> pq = new PriorityQueue<>((o1,o2)->(o2.hp-o1.hp));
		//활성상태 (active==hp) 이고 안죽은거 dead!=0
		for(Cell cell : cellList) {
			if(cell.active==cell.hp && cell.dead!=0) {
				cell.dead--;
				pq.offer(new Cell(cell.x,cell.y,cell.hp,cell.active,cell.dead));
			}
		}
		
		while(!pq.isEmpty()) {
			Cell cell= pq.poll();
			
			for(int i=0; i<4; i++) {
				int nx=cell.x+dx[i];
				int ny=cell.y+dy[i];
				
				if(map[nx][ny]!=0) continue;
				
				map[nx][ny]=cell.hp;
				newCellList.add(new Cell(nx,ny,cell.hp,0,0));
			}
		}
		
		activePlus(); //이전에 존재하는 cell active++해주기
		
		for(Cell cell : newCellList) {
			cellList.add(new Cell(cell.x,cell.y,cell.hp,cell.active,cell.dead));
		}
	}

	private static void activePlus() {
		for(Cell cell : cellList) {
			if(cell.active==cell.hp) continue;
			if(++cell.active==cell.hp) cell.dead=cell.hp;
		}
	}
}
