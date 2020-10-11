package 모의역량테스트;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벌꿀채취 {
	static int N,M,C,subsetMax;
	static int map[][] = new int[11][11];
	static int subsetarray[]; 
	static boolean visit[];
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			subsetarray=new int[M+1];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=1; j<=N; j++) 
					map[i][j]=Integer.parseInt(st.nextToken());
			}
			sb.append("#"+tc+" "+solve()+"\n");
		}
		System.out.println(sb);
	}

	private static int solve() {
		visit = new boolean[11]; //이미 그 행 선택했는지
		return maxHoney()+maxHoney();
	}

	private static int maxHoney() {
		int maxhoney=Integer.MIN_VALUE;
		int visitcheck=0;
		
		for(int i=1; i<=N; i++) {
			if(visit[i]) continue; //이미 행에서 벌꿀을 채취하면 스킵
			for(int j=1; j<=N-(M-1); j++) {
				int value=maxCheck(i,j); //최대값 받아와서
				if(maxhoney<value){ //현재보다 크다면 
					maxhoney=value; //바꾸고
					visitcheck=i;   //visit체크 하기위해 행 저장
				}
			}
		}
		visit[visitcheck]=true;
		return maxhoney;
	}

	private static int maxCheck(int i, int j) {
		int sum=0;
		for(int x=j; x<j+M; x++) sum+=map[i][x];
		
		if(sum>C)  {
			subsetMax=Integer.MIN_VALUE;
			int index=1;
			for(int x=j; x<j+M; x++) subsetarray[index++]=map[i][x]; //길이 M배열에 부분집합에 사용할 원소 집어 넣음
			subset(0,0,0); //부분집합
			return subsetMax;
		}
		else { //다 담아도 c보다 작을 때 
			int notOverSum=0;
			for(int q=j; q<j+M; q++) notOverSum+=Math.pow(map[i][q], 2); //제곱해서 더해서 리턴
			return notOverSum;
		}
	}

	private static void subset(int cnt, int powsum, int sum) {
		if(sum>C) return;
		if(cnt==M) {
			subsetMax=Math.max(subsetMax, powsum);
			return ;
		}
		subset(cnt+1 , powsum+(int)Math.pow(subsetarray[cnt+1], 2) , sum+subsetarray[cnt+1]);
		subset(cnt+1, powsum, sum);
	}
}
