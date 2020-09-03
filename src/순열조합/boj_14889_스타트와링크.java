package 순열조합;

import java.util.Arrays;
import java.util.Scanner;
 
public class boj_14889_스타트와링크 {
    static int table[][],numbers[],N,min;
    static boolean isSelected[];
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
            N=sc.nextInt();
            table=new int [N][N];
            numbers= new int[N/2];
            isSelected= new boolean[N];
             
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    table[i][j]=sc.nextInt();
                }
            }
            min=999999999;
            combination(0,0);
            System.out.println(min);
        
         
    }
    private static void combination(int cnt, int start) {
        if(cnt==N/2) {
            int result=solve();
            min=(result<min)? result:min;
            return;
        }
         
        for(int i=start; i<N; i++) {
             
            numbers[cnt]=i;
            isSelected[i]=true;
            combination(cnt+1,i+1);
            isSelected[i]=false;
        }
    }
    private static int solve() {
         
        int notChoice[] = new int [N/2];
        int index=0;
         
        for(int i=0; i<N; i++) {
            if(!isSelected[i]) notChoice[index++]=i;
        }
        // 조합 n/2 n/2 나누기
        int first=0;
        int second=0;
         
        for(int i=0; i<N/2; i++) {
            for(int j=0; j<N/2; j++) {
                if(i!=j) {
                    first+=table[numbers[i]][numbers[j]];
                    second+=table[notChoice[i]][notChoice[j]];
                }
                 
            }
             
        }
         
        return Math.abs(first-second);
         
    }
 
}