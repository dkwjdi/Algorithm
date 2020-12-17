package 프로그래머스;

public class 타겟넘버 {
	static class Solution {
		int answer;
	    public int solution(int[] numbers, int target) {
	        answer = 0;
	        dfs(numbers,target,0,0,numbers.length);
	        return answer;
	    }

		private void dfs(int[] numbers, int target, int sum, int cnt, int length) {
			if(cnt==length) {
				if(sum==target) answer++;
				return;
			}
			dfs(numbers, target, sum+numbers[cnt], cnt+1, length);
			dfs(numbers, target, sum-numbers[cnt], cnt+1, length);
		}
	}
	
	public static void main(String[] args) {
		int[] numbers= {1,1,1,1,1};
		System.out.println(new Solution().solution(numbers, 3));
	}

	
}
