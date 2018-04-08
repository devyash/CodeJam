import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GoogleCodeJam3 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

	    for (int i = 1; i <= t; ++i) {
		    //give a start point between 2..999
		    // given a find the closes rectangle? and
		    //give start point
		    goGopher(in);
		}
	    System.out.print(sb.toString());
	}

	private static void goGopher(Scanner in) {
		int garden[][] = new int [1000][1000];
		int i = 0;
		int a = 0;
		while(true) {
			if(i==0) {
			    a = in.nextInt();
				System.out.println("499 499");
				garden[499][449]=1;
			}else {
				int x = in.nextInt();
				int y = in.nextInt();
				if(x==-1 && y==-1)
					break;
				if(x==0 && y==0)
					break;
				garden = setGarden(garden,x,y);
				if(!isSolved(a,garden));
				int point[]=getNextMakePoint(garden);
				System.out.println(point[0]+" "+point[1]);
			}
			
		}
		
	}

	private static boolean isSolved(int a, int[][] garden) {
		for(int i = 2;i<999;i++) {
			for(int j=2;j<999;j++) {
//				TODO
			}
		}
		return false;
	}

	private static int[] getNextMakePoint(int[][] garden) {
		for(int i = 2;i<999;i++) {
			for(int j=2;j<999;j++) {
				
			}
		}
		return null;
	}

	private static int[][] setGarden(int[][] garden, int x, int y) {
		garden[x][y]=1;
		return garden;
	}
	
}

