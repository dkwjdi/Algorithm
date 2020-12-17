package 프로그래머스;

public class N개의최소공배수 {
	static class Solution {
	    public int solution(int[] arr) {
	        
	        int size=arr.length;
	        int num1=arr[0];
	        
	        for(int i=1; i<size; i++) {
	        	int num2=arr[i];
	        	
	        	int max=Math.max(num1,num2);
	        	int min=Math.min(num1,num2);
	        	
	        	num1=max*min/gcd(max,min);
	        }
	        return num1;
	    }

		private int gcd(int max, int min) {
			while(min!=0) {
				int r=max%min;
				max=min;
				min=r;
			}
			return max;
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {2,6,8,14};
		System.out.println(new Solution().solution(arr));
	}

}
