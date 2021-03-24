package 프로그래머스_lv2;

public class 점프와순간이동 {
	static class Solution {
		    public int solution(int n) {
		        int ans = 0;

		        while(n>0){
		            if(n%2==0) n/=2;
		            else {
		                n--;
		                ans++;
		            }
		        }

		        return ans;
		    }
		}
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution(6));
	}

}
