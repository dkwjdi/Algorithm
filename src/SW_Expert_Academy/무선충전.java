package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class 무선충전 {
	static class Battery{
		int no,x,y,range,power;
		public Battery(int no,int x, int y, int range, int power) {
			this.no=no;
			this.x = x;
			this.y = y;
			this.range = range;
			this.power = power;
		}
	}
	static int M,A,Amove[], Bmove[];
	static int [] dx= {0,-1,0,1,0};
	static int [] dy= {0,0,1,0,-1};
	static List<Battery> batteryList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			A=Integer.parseInt(st.nextToken());
			
			Amove=new int[M];
			Bmove=new int[M];
			st = new StringTokenizer(br.readLine()); //A사용자
			for(int i=0; i<M; i++) Amove[i]=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()); //B사용자
			for(int i=0; i<M; i++) Bmove[i]=Integer.parseInt(st.nextToken());
			
			batteryList=new ArrayList<>();
			
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine()); 
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int range=Integer.parseInt(st.nextToken());
				int power=Integer.parseInt(st.nextToken());
				batteryList.add(new Battery(i+1,y, x, range, power));
			}
			System.out.println("#"+tc+" "+solve());
		}
		
	}
	private static int solve() {
		int totalCharge=0;
		int Ax=1 ,Ay=1;
		int Bx=10 ,By=10;
		totalCharge+=maxCharge(Ax,Ay,Bx,By);
		
		for(int i=0; i<M; i++) {
			Ax+=dx[Amove[i]];
			Ay+=dy[Amove[i]];
			Bx+=dx[Bmove[i]];
			By+=dy[Bmove[i]];
			totalCharge+=maxCharge(Ax,Ay,Bx,By);
		}
		return totalCharge;
	}
	private static int maxCharge(int ax, int ay, int bx, int by) {
		int sum=0;
		List <Battery>aCharge= new ArrayList<>(); 
		List <Battery>bCharge= new ArrayList<>();
		
		for(int i=0; i<A; i++) { //각가 a,b에 뭐들어가는지
			Battery b = batteryList.get(i);
			if(isIn(b,ax,ay)) {
				aCharge.add(b);
				sum=Math.max(sum, b.power);
			}
			if(isIn(b,bx,by)) {
				bCharge.add(b);
				sum=Math.max(sum, b.power);
			}
		}
		
		for(int i=0; i<aCharge.size(); i++) {
			Battery a=aCharge.get(i);
			for(int j=0; j<bCharge.size(); j++) {
				Battery b=bCharge.get(j);
				
				if(a.no==b.no) sum=Math.max(sum, a.power);
				else sum=Math.max(sum, a.power+b.power);
			}
		}
		return sum;
		
		
	}
	private static boolean isIn(Battery battery, int ax, int ay) {
		if(Math.abs(ax-battery.x)+Math.abs(ay-battery.y)<=battery.range) return true;
		return false;
	}

}
