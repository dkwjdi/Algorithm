package 시뮬레이션;

 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
 
public class boj_16235_나무재테크 {
 
    static int[][] map;
    static int[][] nutrient;
    static int N,M,K =0;
    static int[] dX = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dY = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N:크기,M:나무수,K:시간
        String str = br.readLine();
        String[] strArr = str.split(" ");
         N = Integer.parseInt(strArr[0]);
         M = Integer.parseInt(strArr[1]);
         K = Integer.parseInt(strArr[2]);
         
        map = new int[N][N];
        nutrient = new int[N][N];
        for(int i=0; i<N; i++){
            String str1 = br.readLine();
            String[] strArr1 = str1.split(" ");
            for(int j=0; j<N; j++){
                nutrient[i][j] = Integer.parseInt(strArr1[j]);
                map[i][j] = 5; //최초 기초 양분 5 초기화
            }
        }
         
        LinkedList<Tree> treeList = new LinkedList<>();
        for(int i=0; i<M; i++){
            String str1 = br.readLine();
            String[] strArr1 = str1.split(" ");
            int x = Integer.parseInt(strArr1[0]);
            int y = Integer.parseInt(strArr1[1]);
            int age = Integer.parseInt(strArr1[2]);
            treeList.add(new Tree(x-1, y-1, age, 1));
 
        }
         
        for(int k=0; k<K; k++){
            //봄
            //만약 양분을 못먹으면 즉사
            LinkedList<Tree> newTreeList = new LinkedList<>();
            for(Tree t : treeList){
                if(map[t.x][t.y] >= t.age){
                    map[t.x][t.y] -= t.age;
                    t.age++;
                }else{
                    t.life = 0;
                }
            }
             
            //여름
            for(Iterator<Tree> itt = treeList.iterator(); itt.hasNext();){
                Tree t= itt.next();
                if(t.life == 0){
                    map[t.x][t.y] += t.age / 2;
                    itt.remove();;
                }
            }
             
            //가을
            for(Tree t : treeList){
                if(t.age % 5 == 0)
                for(int j=0; j<8; j++){
                    int nX = t.x + dX[j];
                    int nY = t.y + dY[j];
                    if(-1<nX && nX<N && -1<nY && nY<N){
                        newTreeList.add(new Tree(nX, nY, 1, 1));
                    }
                }
            }
            treeList.addAll(0, newTreeList);
 
            if(k==K-1) {
                System.out.println(treeList.size());
                return;
            }
            //겨울
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] += nutrient[i][j];
                }
            }
         
        }
 
    }
     
    static class Tree{
        int x;
        int y;
        int age;
        int life;
        public Tree(int x, int y, int age, int life) {
            super();
            this.x = x;
            this.y = y;
            this.age = age;
            this.life = life;
        }
         
    }
 
}