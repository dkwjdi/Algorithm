package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 차량정비소 {
	static class Customer implements Comparable<Customer>{
		int no;
		int arrivetime;
		public Customer(int no, int arrivetime) {
			this.no = no;
			this.arrivetime = arrivetime;
		}
		@Override
		public int compareTo(Customer o) {
			return o.no-this.no;
		}
	}
	static int N,M,K,A,B,result;
	static int aTime[], bTime[], aService[][], bService[][];
	static List<Customer> customerList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			
			aTime=new int[N+1];
			bTime=new int[M+1];
			aService=new int[N+1][2];
			bService=new int[M+1][2];
			result=0;
			customerList=new ArrayList<>();
			
			st= new StringTokenizer(br.readLine()," ");
			for(int i=1; i<=N; i++) aTime[i]=Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine()," ");
			for(int i=1; i<=M; i++) bTime[i]=Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine()," ");
			for(int i=1; i<=K; i++) customerList.add(new Customer(i,Integer.parseInt(st.nextToken())));
			Collections.sort(customerList);
			solve();
			System.out.println("#"+tc+" "+(result==0? -1 : result));
		}
		
	}
	private static void solve() {
		Queue <int []> waitQueue = new LinkedList<>();
		int time=-1;
		while(true) {
			time++;
			for(int i=1; i<=N; i++) { //접수
				if(aService[i][0]!=0) { //i번 창구에 사람이 대기 중이면 
					aService[i][1]=aService[i][1]-1;
					if(aService[i][1]==0) {//대기 다했다면 
						waitQueue.add(new int[] {aService[i][0],i}); //자신의 고객번호랑 , 접수창구번호 가지고 수리기다리는 큐로.
						aService[i][0]=0; //접수 창구 비워줌
					}
				}
			}
			for(int i=1; i<=M; i++) { //수리 
				if(bService[i][0]!=0) { //i번 창구에 사람이 대기 중이면 
					bService[i][1]=bService[i][1]-1;
					if(bService[i][1]==0) {//대기 다했다면 
						bService[i][0]=0; //정비 창구 비워줌
					}
				}
			}
			
			for(int i=customerList.size()-1; i>=0; i--) {
				Customer c=customerList.get(i);
				if(c.arrivetime<=time) {  //지금시간에 도착했다면
						if(emptyCheck(aService, N)) { //비어있는 창구가 있다면 
							insert(aService,N,c.no,0); //삽입하고
							customerList.remove(i); //리스트에서 삭제
						}						
						else break; //비어있는 창구 없으면 그냥 넘어감 
				}
			}
			
			while(true) {
				if(!emptyCheck(bService, M) || waitQueue.isEmpty()) break;  //만약 bservice가 비어있지 않다면 끝낸다.
				int [] tmp=waitQueue.poll();
				int no=tmp[0]; //자기 번호
				int useA=tmp[1]; // 접수창구 번호
				insert(bService,M,no,useA);
			}
			if(customerList.size()==0 && waitQueue.isEmpty() && out(aService,N) && out(bService,M)) break;
		}
		return ;
	}
	private static boolean out(int[][] Service, int size) {
		for(int i=1; i<=size; i++) {
			if(Service[i][0]!=0) return false;
		}
		return true;
	}
	private static void insert(int[][] Service, int N, int no, int useA) {
		for(int i=1; i<=N; i++) {
			if(Service[i][0]==0) { //비어 있다면!
				Service[i][0]=no; ///몇번 손님인지 넣어줌 
				
				if(useA==0) Service[i][1]=aTime[i]; //접수창구 시간 넣어주기 
				
				else { //수리창구에서
					Service[i][1]=bTime[i]; //시간
					if(i==B && useA==A) result+=no; //같은 창구썻다면 더해줌  
				}
				return; //넣엇으면 리턴해줌
			}
		}
	}
	private static boolean emptyCheck(int [][] Service,int N) {
		for(int i=1; i<=N; i++) {
			if(Service[i][0]==0) return true;
		}
		return false;
	}
}
