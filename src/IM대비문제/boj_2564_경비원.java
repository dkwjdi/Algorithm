package IM대비문제;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_2564_경비원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int storeNum = sc.nextInt();
	
		List <int[]> list=new ArrayList<>();

		for (int i = 1; i <= storeNum + 1; i++) {
			int storex = sc.nextInt();
			int storey = sc.nextInt();

			if (storex == 1) list.add(new int[] {0,storey,1});
			else if (storex == 2) list.add(new int[] {x,storey,2});
			else if (storex == 3) list.add(new int[] {storey,0,3});
			else list.add(new int[] {storey,y,4});
			
		}
		int distance=0;
		int []dongPoint=list.get(storeNum);
		int dongx=dongPoint[0],dongy=dongPoint[1],dongdir=dongPoint[2];
		
		for(int i=0; i<storeNum; i++) {
			
			int[] storePoint=list.get(i);
			int storex=storePoint[0],storey=storePoint[1],storedir=storePoint[2];
			
			if((dongdir==1 && storedir==2)|| (dongdir==2 && storedir==1)) {
				distance+=Math.min(dongy+(storey)+x, (y-dongy)+(y-storey)+x);
			}
			else if((dongdir==3 &&storedir==4)|| (dongdir==4 && storedir==3)) {
				distance+=Math.min((dongx)+(storex)+y, (x-dongx)+(x-storex)+y);
			}
			else {
				 distance += Math.abs(dongy - storey) + Math.abs(dongx-storex);
			}
		}
		System.out.println(distance);
	}
}
