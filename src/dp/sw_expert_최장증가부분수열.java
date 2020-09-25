package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_expert_최장증가부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			int N=Integer.parseInt(br.readLine());
			long array[]= new long[N];
			long dp[]= new long[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				array[i]=Long.parseLong(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				if(dp[i]==0) dp[i]=1;
				for(int j=0; j<i; j++) {
					if(array[i]>array[j]) {
						if(dp[i]<dp[j]+1)
							dp[i]=dp[j]+1;
					}
				}
			}
			sb.append("#"+tc+" "+Arrays.stream(dp).max().getAsLong()+"\n");
		}
		System.out.println(sb);
	}
}
