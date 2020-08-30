package 순열조합;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class boj_15686_치킨배달 {
	static int N,R,homecnt,chickencnt, chickenmin=99999999;
	static int []numbers;
	static List <Point>chicken = new ArrayList<>();
	static List <Point>home = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		R=sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int tmp=sc.nextInt();
				if(tmp==0) continue;
				else if(tmp==1) {
					home.add(new Point(i,j));
					homecnt++;
				}
				else {
					chicken.add(new Point(i,j));
					chickencnt++;
				}
			}
		}
		numbers = new int [100];
		combination(0,0);
		System.out.println(chickenmin);
	}
	

	private static void combination(int cnt, int start) {
		if (cnt == R) {
			int tmpmin=chickenDistance();
			if(chickenmin>tmpmin){
				chickenmin=tmpmin;
			}
			
			return;
		}
		for (int i = start; i < chickencnt; i++) {
			
			numbers[cnt] = i;
			combination(cnt + 1,i+1);
			
		}
	}


	private static int chickenDistance() {
		
		
		
		int minplus=0;
		
		for(int i=0; i<homecnt; i++) {
			Point homexy =home.get(i);
			int min=99999;
			
			for(int j=0; j<R; j++) {
				Point chickenxy =chicken.get(numbers[j]);
				int distance =Math.abs(chickenxy.x-homexy.x)+Math.abs(chickenxy.y-homexy.y);
				if(distance<min) min = distance;
			}
			minplus+=min;
		}
		return minplus;
		
	}
}



