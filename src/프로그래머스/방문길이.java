package 프로그래머스;

import java.util.HashSet;
import java.util.Set;

public class 방문길이 {
	static class Solution {
	    public int solution(String dirs) {
	        int answer = 0;
	        int dx[]= {-1,1,0,0}; //위 아래 왼 오 
	        int dy[]= {0,0,-1,1};	    
	        Set<String> set = new HashSet<>();
	        int x=5,y=5;
	        
	        dirs=dirs.replace('U', '0').replace('D', '1').replace('L', '2').replace('R', '3');
	        
	        for(int i=0; i<dirs.length(); i++) {
	        	int nx=x+dx[dirs.charAt(i)-'0'];
	        	int ny=y+dy[dirs.charAt(i)-'0'];
	        	
	        	if(nx<0 || ny<0 || nx>10 || ny>10) continue;
	        	
	        	if(!set.contains(x+","+y+","+nx+","+ny)) {
	        		answer++;
	        		set.add(x+","+y+","+nx+","+ny);
	        		set.add(nx+","+ny+","+x+","+y);
	        	}
	        	x=nx;
	        	y=ny;
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution("ULURRDLLU"));
		System.out.println(new Solution().solution("LULLLLLLU"));
	}

}
