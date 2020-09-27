package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1922_네트워크연결 {
	static class Node {
		int no, weight;

		public Node(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
	}

	static int V, E, minEdge[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		minEdge = new int[V + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		visited = new boolean[V + 1];
		List<Node>[] list = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		int start=0;
		int startweight=Integer.MAX_VALUE;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sv = Integer.parseInt(st.nextToken());
			int ev = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (sv == ev)
				continue;
			if(w<startweight) {
				start=sv;
				startweight=w;
			}
			list[sv].add(new Node(ev, w));
			list[ev].add(new Node(sv, w));
		}


		minEdge[start] = 0;
		int minVertex = 0;
		int min = 0;
		int result = 0;

		for (int k = 0; k < V; k++) {
			min = Integer.MAX_VALUE;
			for (int i = 1; i <= V; i++) {
				if (!visited[i] && minEdge[i] < min) {
					minVertex = i;
					min = minEdge[i];
				}
			}

			visited[minVertex] = true;
			result += min;

			int size = list[minVertex].size();
			for (int i = 1; i <= size; i++) {
				Node node = list[minVertex].get(i - 1);
				int no = node.no;
				int weight = node.weight;

				if (!visited[no] && weight != 0 && minEdge[no] > weight) {
					minEdge[no] = weight;
				}

			}

		}
		System.out.println(result);

	}

}
