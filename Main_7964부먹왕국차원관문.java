package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_7964부먹왕국차원관문 {

	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br= new BufferedReader(new StringReader(str));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=1;t<=T;t++) {
			st= new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int D=Integer.parseInt(st.nextToken());
			int[] door= new int[N+2];
			door[0]=1;
			door[N+1]=1;
			st = new StringTokenizer(br.readLine());
	
			for(int i=1;i<=N;i++) {
				door[i]=Integer.parseInt(st.nextToken());
			}
			
			int min=0;
			int cnt=0;
			for(int i=0;i<N+2;i++) {
				if(door[i]==1)
					cnt=0;
				if(cnt==D) {
					min++;
					cnt=0;
				}
				cnt++;
			}
			
			
			sb.append("#"+t+" "+min+"\n");
		}
		
		System.out.println(sb);

	}
	
	static String str ="3\r\n" + 
			"6 2\r\n" + 
			"1 0 0 0 0 1\r\n" + 
			"10 2\r\n" + 
			"0 0 1 0 1 0 0 0 0 1\r\n" + 
			"10 1\r\n" + 
			"0 0 0 0 0 0 0 0 0 0";
	
	static boolean isIn(int i,int n) {
		return 0<=i&&i<n;
	}

}
