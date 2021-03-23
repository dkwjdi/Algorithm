package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1197_최소스패닝트리 {
	static class Node{
		int end;
		int weight;
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int result=0;
		int vertexNum=Integer.parseInt(st.nextToken()); 
		int edgeNum=Integer.parseInt(st.nextToken()); 
		
		List<Node> []info = new List[vertexNum+1];
		boolean [] visited = new boolean[vertexNum+1];
		long [] minEdge=new long[vertexNum+1];
		Arrays.fill(minEdge, Long.MAX_VALUE);
		
		for(int i=0; i<=vertexNum; i++) {
			info[i]=new ArrayList<>();
		}
		
		for(int i=0; i<edgeNum; i++) {
			st= new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken()); 
			int end=Integer.parseInt(st.nextToken()); 
			int weight=Integer.parseInt(st.nextToken()); 
			
			info[start].add(new Node(end,weight));
			info[end].add(new Node(start,weight));
		}
		
		minEdge[1]=0;
		
		
		for(int k=0; k<vertexNum; k++) { //정점의 갯수만큼 돈다
			long min=Long.MAX_VALUE;
			int vertex=0;
			for(int i=1; i<=vertexNum; i++ ) { 	//우선 가장 작은 minEdge를 찾아서 다음 찾아갈 정점 가져온다.
				if(!visited[i] && minEdge[i]<min) {
					min=minEdge[i];
					vertex=i;
				}
			}
			
			//방문처리
			visited[vertex]=true;
			result+=min;
			//위에서 찾은 정점으로 부터 minEdge 갱신해줘라
			
			for(int i=0; i<info[vertex].size(); i++) { //위에서 선택한 정점의 사이즈 만큼 돌면서
				Node node=info[vertex].get(i);
				if(!visited[node.end] && minEdge[node.end]>node.weight)  {  //아직 방문하지 않았고, minEdge값보다 weight가 더적은
					minEdge[node.end]=node.weight;
				}
				
			}
		}
		System.out.println(result);		
	}

}
