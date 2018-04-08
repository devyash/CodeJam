import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GoogleCodeJam {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
			int d = in.nextInt();
			String seq = in.next();
			int res = getSwapCount(seq,d);
			sb.append("Case #").append(i+": ");
			if(res<0)
				sb.append("IMPOSSIBLE\n");
			else
				sb.append(res+"\n");
		}
	    System.out.print(sb.toString());
	}
	
	
	static int getSwapCount(String seq, int maxD) {
		char[] s = seq.toCharArray();
		int swap=0;

		for(int i=seq.length()-1;i>0;) {
			if(i==seq.length()-1) {
				int d =getD(String.valueOf(s));
				if(d<=maxD) {
					return swap;
				}
			}
			if(s[i]=='S' && s[i-1]=='C') {
				char t = s[i];
				s[i]=s[i-1];
				s[i-1]=t;
				swap++;
				i=seq.length();
			}
			i--;
		}
		return -1;
	}
	
	static int getD(String seq) {
		int d =0; int a =1;
		for(char c: seq.toCharArray()) {
			if(c=='S')
				d+=a;
			else 
				a<<=1;
		}
		return d;
	}
}



