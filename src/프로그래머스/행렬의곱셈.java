package 프로그래머스;

public class 행렬의곱셈 {
	static class Solution {
	    public int[][] solution(int[][] arr1, int[][] arr2) {
	        int[][] answer = new int[arr1.length][arr2[0].length];
	        int size=arr2.length;
	        
	        for(int i=0; i<arr1.length; i++) {
	        	for(int j=0; j<arr2[0].length; j++) {
	        		answer[i][j]=cal(i,j,size,arr1,arr2);
	        	}
	        }
	        return answer;
	    }

		private int cal(int i, int j, int size, int[][] arr1, int[][] arr2) {
			int sum=0;
			
			for(int k=0; k<size; k++) {
				sum+=arr1[i][k]*arr2[k][j];
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		int[][] arr2 = {
				{3,3},
				{3,3}
		};

		int[][] arr1 = {
				{1,4},
				{3,2},
				{4,1}
		};
		new Solution().solution(arr1, arr2);
	}
}
