import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class GoogleCodeJam2{

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int [] input = new int[n];
			for (int j = 0; j < n; j++) 
				input[j]=in.nextInt();			
			int res = sortOddEven(input);
			sb.append("Case #").append(i+": ");
			if(res<0)
				sb.append("OK\n");
			else
				sb.append(res+"\n");
		}
	    System.out.print(sb.toString());
	}
	
	
	static int getFaultyIndex(int[] input) {
		// TODO Auto-generated method stub
		if(input.length<=1)
			return -1;
//		input = troubleSort(input);
		for(int i=1;i<input.length;i++) {
			if(input[i-1]>input[i])
				return i-1;
		}
		return -1;
	}

	static int[] troubleSort(int [] input) {
		if(input.length<3)
			return input;
		boolean done = false;
		while(!done) {
			done = true;
			for(int i=0;i<input.length-3;i++) {
				if(input[i]>input[i+2]) {
					done=false;
					int t = input[i];
					input[i] = input[i+2];
					input[i+2]=t;
				}
			}
		}
		return input;
	}

	static int sortOddEven(int [] input) {
		//5 6 8 4 3
		int odd []= new int[input.length/2+1];//2
		int even[]= new int[input.length/2+1];//3
		Arrays.fill(odd, Integer.MAX_VALUE);
		Arrays.fill(even, Integer.MAX_VALUE);
		for(int i=0,j=0;j<input.length;i++,j+=2) {
			even[i]=input[j];//5,8
		}
		for(int i=0,j=1;j<input.length;i++,j+=2) {
			odd[i]=input[j];//5,8
		}
		Arrays.sort(odd);
		Arrays.sort(even);
		for(int i=0,j=0;j<input.length;i++,j+=2) {
			if(even[i]==Integer.MAX_VALUE)
				i++;
			else
				input[j]=even[i];
		}
		for(int i=0,j=1;j<input.length;i++,j+=2) {
			if(odd[i]==Integer.MAX_VALUE)
				i++;
			else
				input[j]=odd[i];//5,8
		}
		
		return getFaultyIndex(input);
		
	}

}
//
////



