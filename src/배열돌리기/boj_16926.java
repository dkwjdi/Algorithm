package 배열돌리기;

import java.util.Scanner;

public class boj_16926 {
	static int N,M,R, map[][];
	static int [] dx= {1,-1,0,0};
	static int [] dy= {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		R=sc.nextInt();
		
		
		map=new int [N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		Rotate(R);
	}
	private static void Rotate(int spin) {
		int n=0;
		int index=0;
		
		for(int i=0; i<spin; i++) {
			
			
			for(int x=0; i<; i++) {
				
			}
			
			while(true) {
				
			}
			
			
			
			
			
			
			
		}
		
	}

}
