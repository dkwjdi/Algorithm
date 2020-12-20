package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 섬연결하기 {
	static class Solution {
		class Node{
			int end, cost;
			public Node(int end, int cost) {
				this.end = end;
				this.cost = cost;
			}
		}
		List<Node> list[];
	    public int solution(int n, int[][] costs) {
	        int answer = 0;
	        
	        int [] minEdge = new int[n];
	        boolean [] visited= new boolean[n];
	        Arrays.fill(minEdge, Integer.MAX_VALUE);
	        list=new List[n];
	        
	        for(int i=0; i<n; i++) {
	        	list[i]=new ArrayList<>();
	        }
	        
	        for(int i=0; i<costs.length; i++) {
	        	list[costs[i][0]].add(new Node(costs[i][1],costs[i][2]));
	        	list[costs[i][1]].add(new Node(costs[i][0],costs[i][2]));
	        }
	        
	        minEdge[0]=0;
	        
	        int vertex=0;
	        int min=Integer.MAX_VALUE;
	        
	        
	        for(int k=0; k<n; k++) {
	        	min=Integer.MAX_VALUE;
	        	for(int i=0; i<n; i++) {
	        		if(!visited[i] && min>minEdge[i]) {
	        			vertex=i;
	        			min=minEdge[i];
	        		}
	        	}
	        	answer+=min;
	        	visited[vertex]=true;
	        	for(int i=0; i<list[vertex].size(); i++) {
	        		int end=list[vertex].get(i).end;
	        		int cost= list[vertex].get(i).cost;
	        		if(!visited[end] &&
	        			minEdge[end]> cost)
	        				minEdge[end]=cost;
	        	}
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		int n=4;
		int[][] costs = {
				{0,1,1},
				{0,2,2},
				{1,2,5},
				{1,3,1},
				{2,3,8}
				
		};
		new Solution().solution(n, costs);
		
	}

}
