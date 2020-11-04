package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_EX_D4_키순서 {
	static int map[][];
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			map= new int[N+1][N+1];

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				map[start][end]=1;
				map[end][start]=-1;
			}
			sb.append("#" + tc + " " + solve() + "\n");
		}
		System.out.println(sb);

	}
	private static int solve() {
		int cnt=0;
		
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j]!=0) continue;
					if(map[i][k]==map[k][j]) map[i][j]=map[i][k];
				}
			}
		}
		
		int tmpcnt=0;
		for (int i = 1; i <= N; i++) {
			tmpcnt=0;
			for (int j= 1; j <= N; j++) {
				if(map[i][j]!=0) tmpcnt++;
			}
			if(tmpcnt==N-1) cnt++;
		}
		
		
		
		return cnt;
	}

	
}








//
//
//package 시뮬레이션;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class SW_EX_D4_키순서 {
//	static class Graph{
//		int end;
//		int back;
//
//		public Graph(int end, int back) {
//			this.end = end;
//			this.back = back;
//		}
//	}
//
//	static List<Graph> parents[];
//	static List<Graph> childs[];
//	static int N, M;
//	static boolean visited[][];
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
//
//		for (int tc = 1; tc <= T; tc++) {
//			N = Integer.parseInt(br.readLine());
//			M = Integer.parseInt(br.readLine());
//
//			parents = new ArrayList[N + 1];
//			childs = new ArrayList[N + 1];
//			for (int i = 0; i <= N; i++) {
//				parents[i] = new ArrayList<>();
//				childs[i] = new ArrayList<>();
//			}
//
//			for (int i = 0; i < M; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//				int start = Integer.parseInt(st.nextToken());
//				int end = Integer.parseInt(st.nextToken());
//				parents[start].add(new Graph(end, 0));
//				childs[end].add(new Graph(start, 1));
//			}
//			sb.append("#" + tc + " " + solve() + "\n");
//		}
//		System.out.println(sb);
//
//	}
//
//	private static int solve() {
//		int cnt = 0;
//		for (int i = 1; i <= N; i++) {
//			boolean check[] = new boolean[N + 1];
//			if (dfs(i, check))
//				cnt++;
//			System.out.println("dd");
//			
//		}
//		return cnt;
//	}
//
//	private static boolean dfs(int curMen, boolean[] check) {
//		check[curMen]=true;
//		parents(curMen, check);
//		child(curMen, check);
//		if (visitedCheck(check))
//			return true;
//		return false;
//	}
//
//	private static boolean visitedCheck(boolean[] check) {
//		for (int i = 1; i <= N; i++) {
//			if (!check[i])
//				return false;
//		}
//		return true;
//	}
//
//	private static void child(int curMen, boolean[] check) {
//		int size = childs[curMen].size();
//
//		for (int i = 0; i < size; i++) {
//	
//				check[childs[curMen].get(i).end] = true;
//				child(childs[curMen].get(i).end, check);
//			
//		}
//	}
//
//	private static void parents(int curMen, boolean[] check) {
//		int size = parents[curMen].size();
//
//		for (int i = 0; i < size; i++) {
//				check[parents[curMen].get(i).end] = true;
//				parents(parents[curMen].get(i).end, check);
//			
//		}
//	}
//
//}
//
