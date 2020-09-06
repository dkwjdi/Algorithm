package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1197_최소스패닝트리prim {
	static class Node implements Comparable<Node> {
		int no, edge;

		public Node(int no, int edge) {
			super();
			this.no = no;
			this.edge = edge;
		}

		@Override
		public int compareTo(Node o) {
			return this.edge - o.edge;
		}
	}

	static List<Node>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int vertexNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[vertexNum + 1];
		long[] minEdge = new long[vertexNum + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		list = new ArrayList[vertexNum + 1];

		for (int i = 0; i <= vertexNum; i++) {
			list[i] = new ArrayList<Node>();
		}

		for (int i = 1; i <= edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[x].add(new Node(y, weight));
			list[y].add(new Node(x, weight));
		}
		long result=0,min = 0;
		
		int minVertex = 0, cnt = 0;
		minEdge[1] = 0;

		for (int c = 0; c < vertexNum; c++) {
			// 신장트리에 포함되지 않은최소간선비용의 정점 찾기
			min = Long.MAX_VALUE;
			for (int i = 1; i <= vertexNum; i++) {
				if (!visited[i] && minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			result += min;
			visited[minVertex] = true;
			// 선택된 최소비용 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 비용 계산하여 최소값 갱신

			for (int i = 0; i < list[minVertex].size(); i++) {
				Node tmp = list[minVertex].get(i);
				if (!visited[tmp.no] && minEdge[tmp.no] > tmp.edge) {
					minEdge[tmp.no] = tmp.edge;

				}
			}
		}

		System.out.println(result);
	}

}
