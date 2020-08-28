
public class test {
public static void main(String[] args) {
	int map[][] = new int [3][3];
	int copymap[][] = new int [3][3];
	
	int index=0;
	for(int i=0; i<3; i++) {
		for(int j=0; j<3; j++) {
			map[i][j]=index++;
		}
	}
	
	for(int i=0; i<3; i++) {
		copymap[i]=map[i];
	}
	
	System.out.println("Dd");
}
}
