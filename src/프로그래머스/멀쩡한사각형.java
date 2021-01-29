package 프로그래머스;

public class 멀쩡한사각형 {
	static class Solution {
	    public long solution(int w, int h) {
	        long answer = 1;
	        
	        if(w>h) {
	        	return h*2;
	        }
	        else if(w<h) {
	        	return 2+(h-2)*2;
	        }
	        else { //(w==h)
	        	return h;
	        }
	        
	        
	    }
	}
	
	public static void main(String[] args) {
		
	}

}
