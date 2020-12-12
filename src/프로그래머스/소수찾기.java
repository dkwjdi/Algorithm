package 프로그래머스;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
	static class Solution {
		int answer = 0;
		boolean visited[];
		String permuNum;
		Set <Integer> set = new HashSet<>();
	    public int solution(String numbers) {
	        
	        int nums[]=new int[numbers.length()];
	        visited= new boolean[numbers.length()];
	        permuNum="";
	        
	        for(int i=0; i<numbers.length(); i++) {
	        	nums[i]=numbers.charAt(i)-'0';
	        }
	        
	        for(int i=1; i<=numbers.length(); i++) {
	        	  permutatoin(0,i,nums);
	        }
	        System.out.println(answer);
	        return answer;
	    }
		private void permutatoin(int cnt, int end, int[] nums) {
			if(cnt==end) {
			
				int prime=Integer.parseInt(permuNum);
				System.out.println(prime);
				if(prime<=1) return;
				
				for(int i=2; i*i<=prime; i++) {
					if(prime%i==0) return;
				}
				
				if(set.contains(prime)) return;
				else set.add(prime);
				answer++;
				return;
			}
			
			for(int i=0; i<nums.length; i++) {
				if(visited[i]) continue;
				visited[i]=true;
				permuNum+=nums[i];
				permutatoin(cnt+1, end, nums);
				permuNum=permuNum.substring(0,cnt);
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) {
		new Solution().solution("1231");
	}

}
