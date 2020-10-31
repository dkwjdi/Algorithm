package 프로그래머스;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 비밀지도 {
	static class Solution {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        String []first = new String[n];
	        String []second = new String[n];
	        
	        String zero="";
	        String firstBinary="";
	        String secondBinary="";
	        
	        for(int i=0; i<n; i++) zero+="0";
	        
	        for(int i=0; i<n; i++) {
	        	firstBinary=Integer.toBinaryString(arr1[i]);
	        	first[i]=zero.substring(0, n-firstBinary.length())+firstBinary;
	        	secondBinary=Integer.toBinaryString(arr2[i]);
	        	second[i]=zero.substring(0, n-secondBinary.length())+secondBinary;
	        }
	        
	        solve(n,arr1,arr2,answer,first,second);
	        
	        return answer;
	    }

		private void solve(int n, int[] arr1, int[] arr2, String[] answer, String[] first, String[] second) {
			for(int i=0; i<n; i++) {
				answer[i]="";
				for(int j=0; j<n; j++) {
					if(first[i].charAt(j)=='1' ||
							second[i].charAt(j)=='1') answer[i]+="#";
					else answer[i]+=" ";
				}
			}
			
		}

	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=5;
		int arr1[]= {9, 20, 28, 18, 11};
		int arr2[]= {30, 1, 21, 17, 28};
		System.out.println(new Solution().solution(n, arr1, arr2));
	}

}
