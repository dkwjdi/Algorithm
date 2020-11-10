package 시뮬레이션;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15684_사다리조작 {
   static int N, M, H;
   static int ladder[][];

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());
      ladder = new int[H + 1][N+1];

      for (int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine(), " ");
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         ladder[a][b] = 1;
         ladder[a][b+1]=-1;
      }

      if(ladderCheck()) {
         System.out.println(0);
         return;
      }

      for (int i = 1; i <= 3; i++) {
         solve(1,1,0,i);
      }
      System.out.println(-1);
   }


   private static void solve(int i, int j, int ladderCnt, int cnt) {
      if(cnt==ladderCnt) {
         if(ladderCheck()) {
            System.out.println(cnt);
            System.exit(0);
         }
         return;
      }
      
      if(j==N+1) {
         j=1; i++;
      }
      
      for(int x=i; x<=H; x++) {
         for(int y=j; y<N; y++) {
            if(ladder[x][y]!=0 || ladder[x][y+1]!=0) continue;
            
            ladder[x][y]=1; ladder[x][y+1]=-1;
            solve(i,j,ladderCnt+1,cnt);
            ladder[x][y]=0; ladder[x][y+1]=0;
         }
      }
      
      
      
      
   }

   private static boolean ladderCheck() {
      
      for(int j=1; j<=N; j++) {
         if(!ladderCheck2(1,j)) return false;
      }
      return true;
   }

   private static boolean ladderCheck2(int x, int y) {
      int starty=y;
      for(int i=1; i<=H; i++) {
         if(ladder[i][y]==-1) y--;
         else if(ladder[i][y]==1) y++;
      }
      if(starty==y) return true;
      return false;
   }

}