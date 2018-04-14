import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class waffelChopper {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
			int r = in.nextInt();
			int c = in.nextInt();
			int h = in.nextInt();
			int v = in.nextInt();
			String temp="";
			String input[] = new String [r];
			for(int a = 0;a<r;a++) {
				if(a==0)
					temp = in.nextLine();
				input[a] = in.nextLine();
			}
			boolean res = isDivideable(input,r,c,h,v);
			sb.append("Case #").append(i+": ");
			if(!res)
				sb.append("IMPOSSIBLE\n");
			else
				sb.append("POSSIBLE\n");
		}
	    System.out.print(sb.toString());
	}

	private static boolean isDivideable(String[] input, int r, int c, int h, int v) {
		char [][] board = new char[r][c];
		int count = 0;
		for(int i=0;i<input.length;i++) {
			String s = input[i];
			for(int j=0;j<s.length();j++) {
				board[i][j]=s.charAt(j);
				if(board[i][j]=='@')
					count++;
			}
		}
		if(count%((h+1)*(v+1))!=0)	return false;
		
		int individualCookies = count/((h+1)*(v+1));
		if(individualCookies==0) return true;
		int [][]tree =buildSegmentTree(board);
//		for(int i=0;i<input.length;i++) {
//			for(int j=0;j<board[0].length;j++) {
//				System.out.println(board[i][j]);
//			}
//		}
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				int asum = sumR(-1,i-1,-1,j-1,tree);
				int bsum = sumR(i-1,r-1,-1,j-1,tree);
				int csum = sumR(-1,i-1,j-1,c-1,tree);
				int dsum = sumR(i-1,r-1,j-1,c-1,tree);
				if(asum==individualCookies && 
				   bsum==individualCookies && 
				   csum==individualCookies &&
				   dsum==individualCookies){
					   return true;
				   }
			}
		}
		
		return false;
	}

	private static int[][] buildSegmentTree(char[][] board) {
		int [][] tree = new int [board.length+1][board[0].length+1];
		int m=board.length;
		int n=board[0].length;
		int nums[][] = new int [m][n];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]=='@')
					update(i, j, 1,nums,tree);
			}
		}
		return tree;
	}
	public static void update(int row, int col, int val, int [][]nums,int tree[][]) {
		int m=nums.length;
		int n=nums[0].length;
        if (m == 0 || n == 0) return;
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }

	private static int sumR(int r1, int r2, int c1, int c2, int[][] tree) {
		// TODO Auto-generated method stub
	     int s = sum(r2+1, c2+1,tree) + sum(r1, c1,tree) - sum(r1, c2+1,tree) - sum(r2+1, c1,tree);
	     if(s<0)
	    	 	return 0;
	     return s;
	}

	private static int sum(int row, int col, int[][] tree) {
        int sum = 0;
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
	}

}