package 프로그래머스;


public class 소수만들기 {
	static class Solution {
		int answer;
		int arr[];
	    public int solution(int[] nums) {
	        answer = 0;
	        arr=new int[3];
	        dfs(nums,nums.length,0,0,0);
	        return answer;
	    }

		private void dfs(int[] nums, int len, int cnt, int sum,int start) {
			if(cnt==3) {
				if(sum%2==0) return;
				
				for(int i=2; i*i<=sum; i++) {
					if(sum%i==0) return;
				}
				answer++;
				return ;
			}
			
			for(int i=start; i<len; i++) {
				arr[cnt]=nums[i];
				dfs(nums,len,cnt+1,sum+nums[i],i+1);
			}
		}
	}
	public static void main(String[] args) {
		int[] nums= {1,2,7,6,4};
		System.out.println(new Solution().solution(nums));
	}

}
