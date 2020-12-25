package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11404_플로이드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int map[][]= new int [n+1][n+1];
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(map[a][b]==0) map[a][b]=c;
			else map[a][b]=Math.min(map[a][b], c);
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(map[i][k]==0 || map[k][j]==0 || i==j) continue;
					if(map[i][j]==0) map[i][j]=map[i][k]+map[k][j];
					else if(map[i][j]>map[i][k]+map[k][j]) map[i][j]=map[i][k]+map[k][j];
					
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
