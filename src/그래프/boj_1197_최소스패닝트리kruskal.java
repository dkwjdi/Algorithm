package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1197_최소스패닝트리kruskal {
	static class Node implements Comparable<Node> {
		int start, end, weight;

		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	static int vertexNum, edgeNum, parents[];
	static PriorityQueue<Node> queue = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		vertexNum = Integer.parseInt(st.nextToken());
		edgeNum = Integer.parseInt(st.nextToken());
		
		parents=new int[vertexNum+1];
		make_set();
		
		for(int i=0; i<edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
		
		int sumWeight=0;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			int v1=find_set(tmp.start);
			int v2=find_set(tmp.end);
			
			if(v1==v2) continue;
			union(v1,v2);
			sumWeight+=tmp.weight;
		}
		System.out.println(sumWeight);
	}

	private static void make_set() {
		for(int i=0; i<=vertexNum; i++) {
			parents[i] = i;
        }
	}
	private static int find_set(int x) {
		if(parents[x]==x) return x; 
		
		return parents[x]=find_set(parents[x]); 
	}
	
	private static void union(int x, int y) {
		x=find_set(x); 
		y=find_set(y); 
		
		if(parents[y]!=x) {
			parents[y]=x; 
		}
	}
}
