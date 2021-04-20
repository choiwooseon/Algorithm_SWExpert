package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_요리사 {

	static int T,N,ans;
	static int[][] s;
	static int min=Integer.MAX_VALUE;
	static boolean isSelected[];
	static int numB[];
	static int numA[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br=new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		
		
		for(int t=1;t<=T;t++) {
			ans=0;
			min=Integer.MAX_VALUE;
			N=Integer.parseInt(br.readLine());
			isSelected=new boolean[N+1];
			numA=new int[N/2];
			numB=new int[N/2];
			s=new int[N+1][N+1];
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					s[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			
			find();
			sb.append("#"+t+" "+ans);
		}
		System.out.println(sb);

	}
	
	static void comb(int cnt,int start) {
		if(cnt==N/2) {
			/*for(int i=1;i<=N/2;i++) {
				for(int j=1;j<=N/2;j++) {
					
				}
			}*/
			comb2(0,0);
			return;
		}
		
		for(int i=start;i<=N;i++) {
			numA[cnt]=i;
			isSelected[i]=true;
			comb(cnt+1,i+1);
		}
		
	}
	
	
	static int[] A= new int[2];
	static int[] B= new int[2];
	
	static void find() {
		comb(0,0);
		int c=0;
		for(int i=1;i<=N;i++) {
			if(isSelected[i]==false) { //B요리 식재료
				numB[c++]=i;
			}
		}
	}
	
	static int suma=0;
	static int sumb=0;
	
	static void comb2(int cnt,int start) {
		if(cnt==2) {
			suma=suma+Math.abs(s[A[0]][A[1]]-s[A[1]][A[0]]);
			sumb=sumb+Math.abs(s[B[0]][B[1]]-s[B[1]][B[0]]);
			ans=Math.min(ans, Math.abs(suma-sumb));
		}
		
		for(int i=start;i<N/2;i++) {
			A[cnt]=numA[i];
			B[cnt]=numB[i];
			comb2(cnt+1,i+1);
		}
	}
	
	static String src="1\r\n" + 
			"4\r\n" + 
			"0 5 3 8\r\n" + 
			"4 0 4 1\r\n" + 
			"2 5 0 3\r\n" + 
			"7 2 3 0";

}
