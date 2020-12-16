package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 자물쇠와열쇠 {
	static class Solution {
		class Point{
			int x,y;
			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
	    public boolean solution(int[][] key, int[][] lock) {
	    	
	        boolean answer = false;
	        int M=key.length; //열쇠
	        int N=lock.length; //자물쇠
	        int size=N+(2*M)-2;
	        int map[][]=new int[size][size];
	        
	        int fillCnt=0; //맞춰야 되는 홈 개수
	        for(int i=0; i<N; i++) {
	        	for(int j=0; j<N; j++) {
	        		if(lock[i][j]==0) fillCnt++; 
	        	}
	        }
	        
	        int idx=0; //큰맵 만들어서 자물쇠 넣어주기 
	        for(int i=M-1 ; i<M-1+N; i++) {
	        	System.arraycopy(lock[idx++], 0, map[i], M-1, N);
	        }
	        
	        
	        List<Point> list = new ArrayList<>();
	        
	        //열쇠 돌기부분 list에 넣기 
	        for(int i=0; i<key.length; i++) { 
	        	for(int j=0; j<key[i].length; j++) {
	        		if(key[i][j]==1) list.add(new Point(i,j));
	        	}
	        }
	        
	        //각각 90도로 돌려서 시작 
	        for(int i=0; i<4; i++) {
	        	if(solve(list,lock, N,M,fillCnt,map)) {
	        		answer=true;
	        		break;
	        	}
	        	
	        	for(int j=0; j<list.size(); j++) {
	        		Point point=list.get(j);
	        		int x=point.y;
	        		int y=(M-1)-point.x;
	        		point.x=x;
	        		point.y=y;
	        	}
	        }
	        return answer;
	    }

		private boolean solve(List<Point> list, int[][] lock, int N, int M, int fillCnt, int[][] map) {
		
			for(int i=0; i<M-1+N; i++) {
				loop :for(int j=0; j<M-1+N; j++) {
					int cnt=0; //몇개나 맞는지 
					//List<Point> copy=new ArrayList<>(list);
					List<Point> copy=new ArrayList<>();
					for(Point point : list) {
						int x=point.x;
						int y=point.y;
						copy.add(new Point(x,y));
					}
					for(int k=0; k<list.size(); k++) {
						//열쇠 옮겨주기 
						Point point=copy.get(k);
						point.x+=i;
						point.y+=j;
					}
					
					//열쇠 다옮겻으면 자물쇠의 홈과 키의 돌기가 맞는지 확인
					for(int k=0; k<copy.size(); k++) {
						//열쇠 옮겨주기 
						Point point=copy.get(k);
						
						//자물쇠 범위에 맞다면 
						if(point.x>=M-1 && point.x<M-1+N &&point.y>=M-1 && point.y<M-1+N) {
							if(map[point.x][point.y]==1) continue loop; //돌기와 돌기가 마주치면 넘어감 
							cnt++; //자물쇠 맞다면 cnt늘려줌
						}
						
					}
					if(cnt==fillCnt) return true;
				}
			}
			return false; 
		}
	}
	
	public static void main(String[] args) {
		int [][]key= {
				{0,0,0},
				{1,0,0},
				{0,1,1}
		};
		int [][]lock= {
				{1,1,1},
				{1,1,0},
				{1,0,1}
		};
		System.out.println(new Solution().solution(key, lock));
	}

}
