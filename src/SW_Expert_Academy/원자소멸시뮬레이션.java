package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 원자소멸시뮬레이션 {
	static class Atom{
		int x,y,dir,energy;
		public Atom(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}
	}
	static int N, map[][]=new int [4001][4001];
	static int []dx= {0,0,-1,1};
	static int []dy= {1,-1,0,0};
	static List <Atom> atomList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			
			atomList=new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x=(Integer.parseInt(st.nextToken())+1000)*2;
				int y=(Integer.parseInt(st.nextToken())+1000)*2;
				int dir=Integer.parseInt(st.nextToken());
				int energy=Integer.parseInt(st.nextToken());
				atomList.add(new Atom(x,y,dir,energy));
			}
			
			System.out.println("#"+tc+" "+solve());
		}
		
		
	}
	private static int solve() {
		int result=0;
		
		while(!atomList.isEmpty()) {
			
			int size=atomList.size();
			if(size<=1) break;
			
			for(int i=size-1; i>=0; i--) {
				Atom atom=atomList.get(i);
				map[atom.x][atom.y]=0; //원래자리 0
				
				//이동
				int nx=atom.x+dx[atom.dir];
				int ny=atom.y+dy[atom.dir];
				
				
				if(nx<0 || ny<0 || nx>4000 || ny>4000) atom.energy=0;
				else {
					map[nx][ny]+=atom.energy;
					atom.x=nx;
					atom.y=ny;
				}
				
				
			}
			
			
			for(int i=size-1; i>=0; i--) {
				Atom atom=atomList.get(i);
				
				if(atom.energy==0) continue;
				
				if(map[atom.x][atom.y]!=atom.energy) {
					result+=map[atom.x][atom.y];
					map[atom.x][atom.y]=0;
					atom.energy=0;
				}
			}
			
			 int index=0;
	            while(true) { // power가 0인 원자 다 삭제
	                if(index==atomList.size()) break;
	                Atom atom= atomList.get(index);
	                if(atom.energy==0) {
	                	atomList.remove(index);
	                    continue;
	                }
	                index++;
	            }
			
			
		}
		return result;
	}

}
