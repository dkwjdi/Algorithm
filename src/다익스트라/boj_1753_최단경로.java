package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1753_최단경로 {
	static class Node {
		int vertex, weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

	}

	static List<Node>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int vertexNum = Integer.parseInt(input[0]);
		int edgeNum = Integer.parseInt(input[1]);
		int start = Integer.parseInt(br.readLine());

		list = new ArrayList[vertexNum + 1];
		int[] distance = new int[vertexNum];
		final int INFINITY = Integer.MAX_VALUE;
		Arrays.fill(distance, INFINITY);
		boolean [] visited = new boolean[vertexNum + 1]; // 처리한 정점 여부 관리

		for (int i = 1; i <= vertexNum; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < edgeNum; i++) {
			input = br.readLine().split(" ");
			int num = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int e = Integer.parseInt(input[2]);
			list[num].add(new Node(v, e));

		}
		
		System.out.println("ddd1");
		System.out.println("Asdf");
		
		distance[start]=0; //자신에서 자신으로 오는비용 0 
		
		int min=0, current=0;
//		
//		for(int i=0; i<V; i++) {
//			min=INFINITY;
//			//1단계 : 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택
//			
//			//이 FOR문이 V개의 연산을 수행하니까  logN으로 줄여주자 
//			for(int j=0; j<V; j++) {
//				if(!visited[j] && min > distance[j]) {
//					min=distance[j];
//					current=j;
//				}
//			}
//			
//			
//			if(current == end ) break;
//			
//			visited[current]=true;
//			
//			//2단계 : 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면  update
//			for(int j=0; j<V; j++) {
//				//min ==> distance[currnet]
//				if(!visited[j] && matrix[current][j]!=0 &&distance[j]> min + matrix[current][j]) {
//					distance[j]=min+matrix[current][j];
//				}
//			}
//			
//		}
//		System.out.println(distance[end]);
	}
}
