package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SW_EX_요리사 {
	static int table[][],numbers[],N,min;
	static boolean isSelected[];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T ;tc++) {
			N=Integer.parseInt(br.readLine());
			table=new int [N][N];
			numbers= new int[N/2];
			isSelected= new boolean[N];
			
			for(int i=0; i<N; i++) {
				String []input=br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					table[i][j]=Integer.parseInt(input[j]);
				}
			}
			min=999999999;
			combination(0,0);
			sb.append("#"+tc+" "+min+"\n");
		}
		System.out.println(sb);
	}
	private static void combination(int cnt, int start) {
		if(cnt==N/2) {
			int result=solve();
			min=(result<min)? result:min;
			return;
		}
		for(int i=start; i<N; i++) {
			numbers[cnt]=i;
			isSelected[i]=true;
			combination(cnt+1,i+1);
			isSelected[i]=false;
		}
	}
	private static int solve() {
		int notChoice[] = new int [N/2];
		int index=0;
		
		for(int i=0; i<N; i++) {
			if(!isSelected[i]) notChoice[index++]=i;
		}
		int first=0, second=0;
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				if(i!=j) {
					first+=table[numbers[i]][numbers[j]];
					second+=table[notChoice[i]][notChoice[j]];
				}
			}
		}
		return Math.abs(first-second);
	}
}
