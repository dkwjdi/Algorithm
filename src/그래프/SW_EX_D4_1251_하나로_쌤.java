package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_EX_D4_1251_하나로_쌤 {
	static int T, N, arr[][];
	static long adjMatrix[][], dist[];
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t =1; t<=T; t++) {
			N=Integer.parseInt(br.readLine());
			
			int []x=new int[N];
			StringTokenizer st =new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				x[i]=Integer.parseInt(st.nextToken());
			}
			int []y=new int[N];
			st =new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				x[i]=Integer.parseInt(st.nextToken());
			}
			
			adjMatrix = new long[N][N];
			
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					adjMatrix[i][j]= adjMatrix[j][i]= getDistance(x[i],x[j],y[i],y[j]);
				}
			} //인접행렬 완성
			
			double E = Double.parseDouble(br.readLine());
			System.out.println("#"+t+" "+Math.round(E*makeMst()));
			
		}

	}

	private static long makeMst() { //프림 알고리즘 
		
		
		
		
		return 0;
	}

	private static long getDistance(int x1, int x2, int y1, int y2) {
		return (long)(Math.pow(x1-x2,2)+Math.pow(y1-y2, 2));
	}

}