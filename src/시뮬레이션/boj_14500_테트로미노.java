package algo;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14500_테트로미노 {
	static int map[][], N,M, result;
	static int dx[]= {0,0,-1,1}; //좌, 우, 상, 하
	static int dy[]= {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		result=Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(result);
	
	}
	private static void solve() {
		//좌(0)   우(1)  상(2)  하(3) 
		int block[][][]= {
				{ // ---- 도형 	
					{1,1,1}, {3,3,3}
				},
				{  // 정사각형 도형
					{1,3,0}
				},
				{
					{3,3,1},{0,0,3},{2,2,0},{1,1,2},{3,3,0},{0,0,2},{2,2,1},{1,1,3}
				},
				{
					{3,0,3},{3,1,3},{0,2,0},{0,3,0},{2,0,2},{2,1,2},{1,2,1},{1,3,1},
				},
				{
					{2,0,1},{2,1,3},{0,1,3},{2,3,0},
				}
		};
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				result=Math.max(result, calScore(i,j,block)+map[i][j]);
			}
		}
	}
	
	private static int calScore(int x, int y, int[][][] block) {
		int score=0;
		
		for(int i=0; i<5; i++) { //5가지 도형 
			for(int j=0; j<block[i].length; j++) { //도형의 경우의 수  
				int nx=x; 
				int ny=y;
				int tmpScore=0;
				for(int k=0; k<block[i][j].length; k++) { //도형 어떻게 생겼는지 
					
					if(i==4) { // ㅗ  모양은 조금 다르게 처리 하니까 따로 빼주기
						nx=x+dx[block[i][j][k]];
						ny=y+dy[block[i][j][k]];
					}
					else { //나머지 모양 
						nx+=dx[block[i][j][k]];
						ny+=dy[block[i][j][k]];
					}
					if(isBound(nx,ny)) tmpScore+=map[nx][ny]; //범위 ok면 점수+
					else {
						tmpScore=0;
						break; //범위 아니라면 break걸어주기
					}
				}
				score=Math.max(score, tmpScore); //최대 점수 갱신 
			}
		}
		return score;
	}
	private static boolean isBound(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=M) return false;
		return true;
	}

}
