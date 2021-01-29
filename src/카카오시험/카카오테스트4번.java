package 카카오시험;

//35분

public class 카카오테스트4번 {
	static class Solution {
		public int solution(int n, int s, int a, int b, int [][] fares) {
			int answer=Integer.MAX_VALUE;
			
			int cost[][]= new int[n+1][n+1];
			
			for(int i=0; i<fares.length; i++) {
				int []fare = fares[i];
				cost[fare[0]][fare[1]]=fare[2];
				cost[fare[1]][fare[0]]=fare[2];
			}
			
			//최소비용으로 갱신 
			for(int k=1; k<=n; k++) {
				for(int i=1; i<=n; i++) {
					for(int j=1; j<=n; j++) {
						if(i==j || cost[i][k]==0 || cost[k][j]==0) continue;
						if(cost[i][j]==0) cost[i][j]=cost[i][k]+cost[k][j];
						else cost[i][j]=Math.min(cost[i][j], cost[i][k]+cost[k][j]);
					}
				}
			}
			
			for(int i=1; i<=n; i++) {
				if(cost[s][i]+cost[i][a]+cost[i][b]==0 ) continue;
				answer=Math.min(cost[s][i]+cost[i][a]+cost[i][b], answer);
			}
			
			return answer;

		}
	}

	public static void main(String[] args) {
		int [][] fares = {
//				{4, 1, 10}, 
//				{3, 5, 24}, 
//				{5, 6, 2}, 
//				{3, 1, 41}, 
//				{5, 1, 24}, 
//				{4, 6, 50}, 
//				{2, 4, 66}, 
//				{2, 3, 22}, 
//				{1, 6, 25}
				
				
				{5, 7, 9}, 
				{4, 6, 4}, 
				{3, 6, 1}, 
				{3, 2, 3}, 
				{2, 1, 6}
				
//				{2,6,6}, 
//				{6,3,7}, 
//				{4,6,7}, 
//				{6,5,11}, 
//				{2,5,12}, 
//				{5,3,20}, 
//				{2,4,8}, 
//				{4,3,9}
		};
		System.out.println(new Solution().solution(7, 3,4, 1, fares));
	}

}
