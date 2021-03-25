package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_최장증가부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int n=Integer.parseInt(br.readLine());
			int[] num=new int[n];
			int[] LSI=new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			
			int max=0;
			for(int i=0;i<n;i++) {
				//LSI 1로 초기화 꼭 시켜주기
				LSI[i]=1;
				for(int j=0;j<i;j++) {
					if(num[j]<num[i]&&LSI[i]<LSI[j]+1) {
						LSI[i]=LSI[j]+1;
					}
					
				}
				//값비교는 여기에서
				if(max<LSI[i])
					max=LSI[i];
			}
			
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb);

	}

}
