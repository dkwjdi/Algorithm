package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_EX_D3_2814_최장경로 {
	static int N,M,result;
	static boolean visited[];
	static  List<Integer> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			list = new List[N+1];
			for(int i=0; i<=N; i++) list[i]=new ArrayList<>();
			for(int i=0; i<M; i++) {
				 st = new StringTokenizer(br.readLine());
				 int start=Integer.parseInt(st.nextToken());
				 int end=Integer.parseInt(st.nextToken());
				 list[start].add(end);
				 list[end].add(start);
			}
			for(int i=1; i<=N; i++) {
				visited = new boolean[N+1];
				solve(i, 1);
			}
			System.out.println("#"+tc+" "+result);
			result=0;
		}
	}
	private static void solve(int start, int cnt) {
		visited[start]=true;
		result=Math.max(result, cnt);
		for(int i=0; i<list[start].size(); i++) {
			int nextVertex=list[start].get(i);
			if(!visited[nextVertex]) {
				solve(nextVertex,cnt+1);
				visited[nextVertex]=false;
			}
		}
	}
}
