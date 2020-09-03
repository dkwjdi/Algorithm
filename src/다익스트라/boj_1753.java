package 다익스트라;

/*
 *
 * 
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;



public class boj_1753 {
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
		String []input = br.readLine().split(" ");
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[0]);
		int start = Integer.parseInt(br.readLine());

		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		list = new ArrayList[V];
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			String data = br.readLine();
			StringTokenizer st = new StringTokenizer(data);
			list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}

		

		final int INFINITY = Integer.MAX_VALUE;
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;

		int min = 0;
		int current = 0;

		for (int i = 0; i < V; i++) {
			min = INFINITY;

			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			

//			visited[current] = true;
//
//			for (int j = 0; j < V; j++) {
//				if (!visited[j] && graph[current][j] != 0 && distance[j] > min + graph[current][j])
//					distance[j] = min + graph[current][j];
//			}

		}
//		System.out.println(distance[end]);
	}

}
