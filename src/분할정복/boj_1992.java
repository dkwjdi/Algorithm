package 분할정복;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1992 {
	 
	    private static int n, m;
	    private static int map[][];
	 
	    public static void main(String[] args) throws NumberFormatException, IOException   {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        n = Integer.parseInt(br.readLine());
	 
	        map = new int[n][n];
	        int[] num = new int[n];
	 
	        for (int i = 0; i < n; i++) {
	            String input = br.readLine();
	            for (int j = 0; j < n; j++) {
	                num[j] = input.charAt(j);
	                map[i][j] = (int)num[j] - '0';
	                		
	            }
	        }
	        divide(0, 0, n);
	    }
	 
	    private static boolean sameCheck(int x, int y, int n) {
	        int same = map[x][y];
	        for (int i = x; i < x + n; i++) {
	            for (int j = y; j < y + n; j++) {
	                if (same != map[i][j]) {
	                    return false;
	                }
	            }
	        }
	        m = same;
	        return true;
	    }
	 
	    private static void divide(int x, int y, int n) {
	        if (sameCheck(x, y, n)) { //모든숫자 같을 때
	            System.out.print(m);
	        } else { //다를 때
	            System.out.print("(");
	            int newn = n / 2;
	            for (int i = 0; i < 2; i++) {
	                for (int j = 0; j < 2; j++) {
	                    divide(x + newn * i, y + newn * j, newn);
	                }
	            }
	            System.out.print(")");
	        }
	    }
	}


