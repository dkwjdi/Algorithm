package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1916_최소비용구하기 {
	static class Node{
		int end,weight;
		public Node( int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	static int V,E,start,end;
	static int minEdge[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V=Integer.parseInt(br.readLine());
		E=Integer.parseInt(br.readLine());
		List <Node> []list = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			list[i]=new ArrayList<>();
		}
		
		minEdge = new int [V+1];
		visited = new boolean [V+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sv=Integer.parseInt(st.nextToken());
			int ev=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			int size=list[sv].size();
			for(int j=0; j<size; j++) {
				if(list[sv].get(j).end==ev) {
					if(list[sv].get(j).weight>w) {
						list[sv].add(new Node(ev,w));
					}
					continue;
				}
			}
			list[sv].add(new Node(ev,w));
		}
		st = new StringTokenizer(br.readLine()," ");
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		minEdge[start]=0;
		
		int minVertex=0;
		int min=0;
		for(int j=0; j<V; j++) {
			min=Integer.MAX_VALUE;
			for(int i=1; i<=V; i++) {
				if(minEdge[i]<min && !visited[i]) {
					minVertex=i;
					min=minEdge[i];
				}
			}
			if(minVertex==end) 	{
				System.out.println(min);
				return;
			}
			visited[minVertex]=true;
			
			int size=list[minVertex].size();
			for(int i=1; i<=size; i++) {
				int end=list[minVertex].get(i-1).end;
				int weight=list[minVertex].get(i-1).weight;
				if(!visited[end] &&  minEdge[end]>weight+minEdge[minVertex]) {
					 minEdge[end]=weight+minEdge[minVertex];
				}
			}
		}
		System.out.println(minEdge[end]);
	}

}
