import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BitParty {
	static class Cashier{
		public Cashier(int m, int s, int p) {
			this.m=m;
			this.s=s;
			this.p=p;

		}
		int m;
		int s;
		int p;

		int timeTake(int n) {
			if(n>this.m)
				return -1;
			return (this.s*n+this.p);
		}
	}
	//3
	//2 2 2
	//1 2 3
	//1 1 2
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int r = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			Cashier[] list = new Cashier[c];
			for(int a = 0;a<c;a++) {
				int m = in.nextInt();
				int s = in.nextInt();
				int p = in.nextInt();
				list[a] = new Cashier(m,s,p);
			}
			boolean res = MinTime(r,b,list);
			sb.append("Case #").append(i+": ");
			if(!res)
				sb.append("IMPOSSIBLE\n");
			else
				sb.append("POSSIBLE\n");
		}
	}
	private static boolean MinTime(int r, int b, Cashier[] list) {
		// get scheduling algorithms

		return false;
	}
}
