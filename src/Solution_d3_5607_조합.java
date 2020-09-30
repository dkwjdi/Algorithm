 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_d3_5607_조합 {
    static int mod = 1234567891;
    static int N;
    static long[] factorial;
    
    static int R;
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int T=Integer.parseInt(br.readLine());
        factorial=new long[1000000+1];
        factorial[0]=1;
        for(int i=1;i<=1000000;i++)
            factorial[i]=(factorial[i-1]*i)%mod;        //factorial 초기화
        
        for(int tc=1;tc<=T;tc++) {
            st= new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            R=Integer.parseInt(st.nextToken());
            
            
            long top = factorial[N]%mod;
            long bottom = ((factorial[N-R]%mod ) * (factorial[R]%mod))%mod;
            
            long moveToTop = powCalc(bottom,mod-2);
            
            System.out.println("#" +tc+" "+((top*moveToTop)%mod));
        }
    }
    
    static long powCalc(long num,int p) {
        if(p==0)
            return 1;
        
        long half = powCalc(num, p/2);
        
        if(p%2==0) {
            return ((half%mod) * (half%mod))%mod;
        }else
            return (((half*num)%mod) * (half%mod))%mod;
    }
}
 
