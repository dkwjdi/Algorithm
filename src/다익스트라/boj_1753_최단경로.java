package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class boj_1753_최단경로 {
	static class Node{
		int end,weight;
		public Node( int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	static int V,E,start;
	static int minEdge[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		List <Node> []list = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			list[i]=new ArrayList<>();
		}
		
		minEdge = new int [V+1];
		visited = new boolean [V+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		start = Integer.parseInt(br.readLine());
		minEdge[start]=0;
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sv=Integer.parseInt(st.nextToken());
			int ev=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			list[sv].add(new Node(ev,w));
		}
		
		int minVertex=0;
		int min=Integer.MAX_VALUE;
		
		for(int t=0; t<V; t++) { //정점갯수만큼 돌아야함
			min=Integer.MAX_VALUE;
			for(int i=1; i<=V; i++) { //정점찾기
				if(!visited[i] &&minEdge[i]<min) {
					minVertex=i;
					min=minEdge[i];
				}
			}
			visited[minVertex]=true;
			int size=list[minVertex].size();
			
			for(int i=1; i<=size; i++) { //최단거리 갱신해주기
				int end=list[minVertex].get(i-1).end;
				int weight=list[minVertex].get(i-1).weight;
				if(!visited[end] && 
						weight!=0&&
						minEdge[end]>weight+minEdge[minVertex]) {
					minEdge[end]=weight+minEdge[minVertex];
				}
			}
			
			
		}
		for(int i=1; i<=V; i++) { //최단거리 갱신해주기
			if(minEdge[i]==Integer.MAX_VALUE) System.out.println("INF");
			else {
				System.out.println(minEdge[i]);
			}
		}
	}

}
