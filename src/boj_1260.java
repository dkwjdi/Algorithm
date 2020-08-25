import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1260 {
	static int map[][];
	static boolean visit[];
	static int Vertex, Edge, startVertex, max;
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		

		Vertex = sc.nextInt();
		Edge = sc.nextInt();
		startVertex = sc.nextInt();
		map = new int[Vertex + 1][Vertex + 1];
		visit = new boolean[Vertex + 1];

		for (int i = 0; i < Edge; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from][to] = 1;
			map[to][from] = 1;
		}

		dfs(startVertex);
		for(int i=0; i<=Vertex; i++) {
			visit[i]=false;
		}
		sb.append("\n");
		bfs(startVertex);
		System.out.println(sb.toString());
	}

	private static void dfs(int start) {

		visit[start] = true;
		sb.append(start+" ");

		for (int i = 1; i <= Vertex; i++) {
			if (map[start][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}

	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();

		
		queue.offer(start);
		visit[start] = true;
		sb.append(start);

		while (!queue.isEmpty()) {

			int tmp = queue.poll();
			for (int i = 1; i <= Vertex; i++) {
				if (map[tmp][i] == 1 && visit[i] == false) {
					queue.offer(i);
					visit[i] = true;
					sb.append(" " + i);
				}
			}

		}

	}

}