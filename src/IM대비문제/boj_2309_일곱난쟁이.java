package IM대비문제;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2309_일곱난쟁이 {
	static int [] input, height;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[9];
		height = new int[7];
		
		for(int i=0; i<9; i++) {
			input[i]=sc.nextInt();
		}
		solve(0,0);
	}
	private static void solve(int cnt,int start) {
		if(cnt==7) {
			int sum=0;
			for(int i=0; i<7; i++) 
				sum+=height[i];
			
			if(sum==100) {
				Arrays.sort(height);
				for(int i=0; i<7; i++) {
					sb.append(height[i]+"\n");
				}
				System.out.println(sb);
				System.exit(0);
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			height[cnt]=input[i];
			solve(cnt+1,i+1);
		}
	}
}
