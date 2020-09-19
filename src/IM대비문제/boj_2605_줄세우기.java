package IM대비문제;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_2605_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		List <Integer> list=new ArrayList<>();
		int index=0;
		for(int i=0; i<N; i++) {
			index=list.size()-sc.nextInt();
			list.add(index,i+1);
		}
		
		for(int result:list) 
			System.out.print(result+" ");
	}
}
