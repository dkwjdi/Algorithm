package IM대비문제;

import java.util.Scanner;

public class boj_2669_직사각형네개의합집합의면적구하기 {
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		// 전체 좌표 크기의 배열
 		boolean[][]map = new boolean[101][101];
 		int cnt = 0;
 		for(int i=0; i<4; i++) {
 			int x1 = sc.nextInt(), y1 = sc.nextInt();
 			int x2 = sc.nextInt(), y2 = sc.nextInt();
 			for(int x=x1; x<x2; ++x) {
 				for(int y=y1; y<y2; ++y) {
 					if(!map[y][x]) {
 						map[y][x] = true;
 						cnt++;
 					}
 				}
 			}
 		}
 		System.out.println(cnt);
 		
 	}
}