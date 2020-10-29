package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장 {
	static int cost[]=new int [4];
	static int month[]=new int [13];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<4; i++) {
				cost[i]=Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=12; i++) {
				month[i]=Integer.parseInt(st.nextToken());
			}
			result=cost[3]; //1년치 
			solve(1,0);
			
			sb.append("#" + tc + " " + result + "\n");
		}
		
		System.out.println(sb);
	}
	private static void solve(int resultMonth, int resultCost) {
		if(resultMonth==13) {
			result=Math.min(result, resultCost);
			return ;
		}
		if(result<=resultCost) return ;
		if(month[resultMonth]==0) solve(resultMonth+1,resultCost);
		
		solve(resultMonth+1,resultCost+(cost[0]*month[resultMonth])); //1일치
		solve(resultMonth+1,resultCost+cost[1]); //1달
		if(resultMonth<=10) solve(resultMonth+3,resultCost+cost[2]); //3달
		
	}

}
