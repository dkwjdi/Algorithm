package 프로그래머스;

import java.util.Arrays;

public class 최솟값만들기 {
	static class Solution {
		public int solution(int[] A, int[] B) {
			int answer = 0;
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int size=A.length;
			for(int i=0; i<size; i++) {
				answer+=A[i]*B[size-1-i];
			}
			return answer;
		}
	}
	public static void main(String[] args) {
		int []A= {1,5,10};
		int []B= {20,10,3};
		System.out.println(new Solution().solution(A, B));
	}
}
