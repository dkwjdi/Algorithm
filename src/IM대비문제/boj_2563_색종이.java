package IM대비문제;

import java.util.Scanner;

public class boj_2563_색종이 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int map[][]=new int[101][101];
		
		int n=sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			check(x,y,map);
		}
		System.out.println(sum(map));
	}

	private static int sum(int[][] map) {
		int result=0;
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(map[i][j]==1) result++; 
			}
		}
		return result;
		
	}

	private static void check(int x, int y, int [][]map) {
		for(int i=x; i<x+10; i++) {
			for(int j=y; j<y+10; j++) {
				map[i][j]=1;
			}
			
		}
		
	}

}
